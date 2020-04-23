package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

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
        final Connection con = null;
        try{
            ConnectionDAO.getInstance().getConnection();
            final PreparedStatement pst = con.prepareStatement("INSERT INTO reviews (Products_idProducts, Users_idUser, title, text, scoreProduct, scoreReview, scoreReviewParticipants) VALUES(?,?,?,?,?,?,?)");

            pst.setInt(1,ProductDAO.getProductID(product.getName()));
            pst.setInt(2,UserDAO.getUserID(review.getUser()));
            pst.setString(3,review.getCommentTitle());
            pst.setString(4, review.getComment());
            pst.setInt(5, review.getProductScore());
            pst.setInt(6, 0);
            pst.setInt(7, 0);

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
    public static void main(final String[] args) {

        final Product product = null;
        ReviewDAO.loadProductReview(product);
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
}
