package DAO;

import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

public class BrandsDAO {
    public static Collection<String> getAllBrands() {
        ArrayList<String> brands = new ArrayList<String>();
        Connection con = null;
        try {
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT brandName FROM brands");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                brands.add(rs.getString(1));
                //System.out.println(rs.getString(2));
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        return brands;
    }
}
