package DAO;

import domain.Product;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDAO {
    public static void uploadProduct(Product product){
        try{
            Connection con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("INSERT INTO Products (name,desciption,productCategory,productImg,price) VALUES(?,?,?,?,?)");
            pst.setString(1,product.getName());
            pst.setString(2,product.getDescription());
            pst.setString(3,product.getCategory());
            pst.setBytes(4,null);
            pst.setFloat(5,product.getPrice());

            pst.execute();
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
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
    public void main(String args[]){
        Product prod = new Product("test1","descripcion","test",null,100,10);
        ProductDAO.uploadProduct(prod);
    }
}
