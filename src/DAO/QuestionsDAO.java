package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class QuestionsDAO {
    public static Collection<String> getAllFeatures() {
        ArrayList<String> questions = new ArrayList<String>();
        Connection con = null;
        try {
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT questionText FROM questions");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                questions.add(rs.getString(1));
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
