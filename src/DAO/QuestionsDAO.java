package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class QuestionsDAO {
    public static HashMap<Integer,String> getAllQuestions() {
        HashMap<Integer,String> questions = new HashMap<Integer,String>();
        Connection con = null;
        try {
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT idQuestion, questionText FROM questions");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                questions.put(rs.getInt(1),rs.getString(2));
                //System.out.println(rs.getString(2));
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        return questions;
    }
}
