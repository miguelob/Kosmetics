package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import domain.Product;
import domain.Review;
import domain.User;

public class ReviewDAO {
    public static void loadProductReview(Product product) {
        Connection con = null;
        //QUERY for loading reviews. we also need the query user
        try{
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM reviews WHERE  Products_idProducts = ?");
            pst.setInt(1,product.getId());
             ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                product.addReview(new Review(UserDAO.getUser(rs.getInt(6)), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(9)));
            }

        } catch (final SQLException sqle) {

            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        }catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static boolean uploadReview(Review review, Product product) {
        boolean status = false;
        try{
            final Connection con=ConnectionDAO.getInstance().getConnection();
            final PreparedStatement pst = con.prepareStatement("INSERT INTO reviews (scoreProduct, title, text, Users_idUser,  Products_idProducts, Products_Brands_idBrands, fechaReview) VALUES(?,?,?,?,?,?,?)");

            pst.setInt(1,review.getProductScore());
            pst.setString(2,review.getCommentTitle());
            pst.setString(3,review.getComment());
            pst.setInt(4,UserDAO.getUserID(review.getUser()));
            pst.setInt(5,product.getId());
            pst.setInt(6,0);
            pst.setDate(7,convertUtilToSql(review.getDate()));

            pst.executeUpdate();
            status = true;

        } catch (final SQLException sqle) {
            System.err.format("SQL State: %s\n%s", sqle.getSQLState(), sqle.getMessage());
        }catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }catch (final Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    public static void getReviews(User tempUser, ArrayList<Review> reviewList) {
        // TODO Auto-generated method stub
        Connection con = null;
        //QUERY for loading reviews. we also need the query user
        try {
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM reviews WHERE = Users_idUser = " + UserDAO.getUserID(tempUser));
             ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                //reviewList.add(new Review(tempUser, rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(5), rs.getString(4)));
            }

        } catch (final SQLException sqle) {

            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        }catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }

    }

    public static ArrayList<Review> getAllUserReviews(User user) {
        ArrayList<Review> reviews = new ArrayList<Review>();
        Connection con = null;
        //QUERY for loading reviews. we also need the query user
        try{
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM reviews WHERE  Users_idUser = ?");
            pst.setInt(1,UserDAO.getUserID(user));
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                reviews.add(new Review(user, rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getString(9)));
            }

        } catch (final SQLException sqle) {

            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        }catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return reviews;
    }
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}
