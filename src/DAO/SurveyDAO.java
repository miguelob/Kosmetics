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
    public static boolean uploadSurvey(Product product) {
        boolean status=true;
        try {
            System.out.println("pez");
            Connection con = ConnectionDAO.getInstance().getConnection();
            Survey survey=product.getSurvey();
            System.out.println(survey);
            for (Question q:survey.getQuestions()) {

                PreparedStatement pst = con.prepareStatement("UPDATE products_questions SET numYes= ?, numNo= ?, numNoAnswer= ? WHERE Questions_idQuestion= ?");
                System.out.println(survey.getQuestionRespuesta(q)[0]+survey.getQuestionRespuesta(q)[1]+survey.getQuestionRespuesta(q)[2]);
                pst.setInt(1,survey.getQuestionRespuesta(q)[0]);
                pst.setInt(2,survey.getQuestionRespuesta(q)[1]);
                pst.setInt(3,survey.getQuestionRespuesta(q)[2]);
                pst.setInt(2, q.getIdQuestion());
            }

        } catch (Exception e) {
            e.printStackTrace();
            status=false;
        }
        return status;
    }
}
