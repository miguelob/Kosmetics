package DAO;

import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class BrandsDAO {
    public static HashMap<Integer,String > getAllBrands() {
        HashMap<Integer,String> brands = new HashMap<Integer,String>();
        Connection con = null;
        try {
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT idBrands, brandName FROM brands");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                brands.put(rs.getInt(1),rs.getString(2));
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

    public static String getBrandFromId(int brands_idBrands) {
        String brand = "";
        Connection con = null;
        try {
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT brandName FROM brands WHERE idBrands = ?");
            pst.setInt(1,brands_idBrands);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                brand = rs.getString(1);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        return brand;
    }
}
