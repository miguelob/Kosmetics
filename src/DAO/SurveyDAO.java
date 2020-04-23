package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import domain.Product;
import domain.Question;
import domain.Survey;

public class SurveyDAO {
    public static void getSurvey(Product product) {
        Survey survey = new Survey();
        Connection con = null;
        //WE NEED QUERY FOR GET THE INFO WITH EACH ID
        try{
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM  products_questions WHERE Products_idProducts = ?");
            pst.setInt(1,product.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //System.out.println("\nValor1: "+rs.getInt(2)+"\nValor2: "+rs.getInt(3)+"\nValor3: "+rs.getInt(4));
                survey.put(SurveyDAO.getQuestion(rs.getInt(2)), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            }
            product.setSurvey(survey);
        } catch (SQLException | ClassNotFoundException sqle) {

            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        }
    }
    private static Question getQuestion(int id) {
        Question question = null;
        Connection con = null;
        //WE NEED QUERY FOR GET THE INFO WITH EACH ID
        try{
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM questions WHERE idQuestion = ?");
            pst.setInt(1,id);
             ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                question = new Question(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException sqle) {

            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        return question;
    }
    public static boolean uploadSurvey(Product product, HashMap<Integer,int[]> ans) {
        boolean status = false;
        try {
            Connection con = ConnectionDAO.getInstance().getConnection();
            int idSurvey = ProductDAO.getSurveyID(product);
            Collection<Question> questions = product.getSurvey().getQuestions();
            int contador = 1;
            Iterator<Question> it = questions.iterator();
            while (it.hasNext()) {
                Question question = (Question) it.next();
                int[] yes = {1, 0, 0};
                int[] no = {0, 0, 1};
                int[] yesNo = {0, 1, 0};
                if (Arrays.equals(ans.get(contador), yes)) {
                    try {
                        final PreparedStatement pst = con.prepareStatement("UPDATE \"IDs_Surv_Quest\" SET \"Number_Yes\" = \"Number_Yes\" + 1 WHERE \"ID_Survey\" = '" + idSurvey + "' AND \"ID_Question\" = '" + question.getIdQuestion() + "'");
                        pst.executeUpdate();
                        status = true;
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                } else if (Arrays.equals(ans.get(contador), no)) {
                    try {
                        final PreparedStatement pst = con.prepareStatement("UPDATE \"IDs_Surv_Quest\" SET \"Number_No\" = \"Number_No\" + 1 WHERE \"ID_Survey\" = '" + idSurvey + "' AND \"ID_Question\" = '" + question.getIdQuestion() + "'");
                        pst.executeUpdate();
                        status = true;
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                } else if (Arrays.equals(ans.get(contador), yesNo)) {
                    try {
                        final PreparedStatement pst = con.prepareStatement("UPDATE \"IDs_Surv_Quest\" SET \"Number_No_answer\" = \"Number_No_answer\" + 1 WHERE \"ID_Survey\" = '" + idSurvey + "' AND \"ID_Question\" = '" + question.getIdQuestion() + "'");
                        pst.executeUpdate();
                        status = true;
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                contador++;
            }
        }catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
