package DAO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sun.source.tree.CaseTree;
import domain.Product;
import domain.User;

public class UserDAO {
    public static User getUser(int i) {
        User user = null;
        Connection con = null;
        //WE NEED QUERY FOR GET THE INFO WITH EACH ID
        try {
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE idUser =  ?");
            pst.setInt(1,i);
             ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                user = new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getBoolean(8),UserDAO.checkImg(i,"",0));
            }
        } catch (SQLException sqle) {

            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException | ParseException cnfe){
            cnfe.printStackTrace();
        }
        return user;
    }
    //LOGIN-> el metodo funciona tanto si el campo name es el nombre de usuario o es el correo
    //COMPROBAR QUE FUNCIONA

    /*public static boolean chicPermision(String name, String password) {
        boolean permision = false;
        Connection con=ConnectionDAO.getInstance().getConnection();
        //WE NEED QUERY FOR GET THE INFO WITH EACH ID
        try (PreparedStatement pst = con.prepareStatement("SELECT EXISTS(	SELECT * FROM \"Users\" WHERE ( \"Name\" = " + name + "or \"E-mail\" = " + name + " ) and \"Password\" = " + password + ")");
            ResultSet rs = pst.executeQuery()) {
            permision=Boolean.parseBoolean(rs.getString(1));//si no es ni true ni false por defecto es false

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return permision;
    }*/
    public static User login(String userOrEmail, String passw) {
        User user = null;
        Connection con = null;
        //WE NEED QUERY FOR GET THE INFO WITH EACH ID
        try {
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE (email = ? OR name = ?) AND password = ?");
            pst.setString(1,userOrEmail);
            pst.setString(2,userOrEmail);
            pst.setString(3,passw);
             ResultSet rs = pst.executeQuery();

            if(rs.next()) {
                user = new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getBoolean(9),UserDAO.checkImg(0,userOrEmail,0));
                //System.out.println(rs.getInt(8));
            }
        } catch (SQLException sqle) {

            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return user;
    }
    public static boolean uploadUser(User user) {
        boolean status = false;
        Connection con = null;
        try{
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("INSERT INTO users(email, password, name, birthDate, skinColor, skinCondition, userImg, admin) VALUES(?,?,?,?,?,?,?,?)");

            pst.setString(1,user.getEmail());
            pst.setString(2,user.getPassword());
            pst.setString(3,user.getName());
            pst.setDate(4, UserDAO.convertUtilToSql(user.getBirthDate()));
            pst.setString(5,user.getSkinColor());
            pst.setString(6,user.getSkinCondition());
            pst.setBytes(7,null);//getImageBytes(user.getProfileImage()));//UserDAO.getImageBytes(user.getProfileImage()));
            pst.setBoolean(8,user.getAdmin());

            pst.executeUpdate();
            status = true;

        } catch (SQLException sqle) {
            System.err.format("SQL State: %s\n%s", sqle.getSQLState(), sqle.getMessage());
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return status;
    }
    public static int getUserID(User user) {
        int id = -1;
        Connection con = null;
        try{
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT idUser FROM  users WHERE email = ?");
            pst.setString(1,user.getEmail());
             ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException sqle) {

            System.out.println(sqle.getMessage());
            sqle.printStackTrace();

        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        return id;
    }
    public static int checkUsername(User user) {
        int id = -1;
        Connection con = null;
        try{
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT idUser FROM  users WHERE name = ?");
            pst.setString(1,user.getName());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException sqle) {

            System.out.println(sqle.getMessage());
            sqle.printStackTrace();

        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        return id;
    }
    public static int checkEmail(User user) {
        int id = -1;
        Connection con = null;
        try{
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT idUser FROM  users WHERE email = ?");
            pst.setString(1,user.getEmail());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException sqle) {

            System.out.println(sqle.getMessage());
            sqle.printStackTrace();

        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        return id;
    }
    public static boolean checkImg(int id,String name, int opc) {
        boolean status = false;
        Connection con = null;
        try{
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = null;
            if(opc == 0){
                pst = con.prepareStatement("SELECT userImg FROM  users WHERE idUser = ?");
                pst.setInt(1,id);
            }else{
                pst = con.prepareStatement("SELECT userImg FROM  users WHERE name = ?");
                pst.setString(1,name);
            }
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                if(rs.getBlob(1) != null){
                    status = true;
                }
            }
        } catch (SQLException sqle) {

            System.out.println(sqle.getMessage());
            sqle.printStackTrace();

        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        return status;
    }
    private static byte[] getImageBytes(ImageIcon image) {
        byte[] imgBytes = null;
        try {
            BufferedImage bImage = (BufferedImage) image.getImage();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "jpg", bos );
            imgBytes = bos.toByteArray();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return imgBytes;
    }
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    public static byte[] getUserImg(String name) {
        byte[] retorno = null;
        Connection con = null;
        try {
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT userImg FROM users WHERE name = ?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                retorno = rs.getBytes(1);
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return retorno;
        }
}
