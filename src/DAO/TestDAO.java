package DAO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;

import javax.imageio.ImageIO;

public class TestDAO {



	/*public static void getTests() {
		 byte [] data = null;
	    try {
	    	BufferedImage bImage = ImageIO.read(new File("2.jpg"));
	    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(bImage, "jpg", bos );
			data = bos.toByteArray();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(data);
		Connection con=ConnectionDAO.getInstance().getConnection();
		try{
			PreparedStatement pst = con.prepareStatement("UPDATE \"Products\" SET \"Image\" = ? WHERE \"ID_Product\" = ?");
			pst.setBytes(1,data);
			pst.setInt(2, 2);

            int row = pst.executeUpdate();
            System.out.println(row);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}*/

    public static void getTests() {
        Connection con = null;
        try{
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("INSERT INTO \"Users\"(\"E-mail\", \"Password\", \"Name\", \"Birth_Date\", \"Skin_Color\", \"Skin_Condition\", \"Image\") VALUES(?,?,?,?,?,?,?)");

            pst.setString(1,"oleoblancomiguel@gmail.com");
            pst.setString(2,"1234");
            pst.setString(3,"Test4");
            pst.setDate(4, (java.sql.Date) new Date((long) 17.5) );
            pst.setString(5,"white");
            pst.setString(6,"OK");
            pst.setBytes(7,null);

            int affectedRows = pst.executeUpdate();
            System.out.println(affectedRows);

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        TestDAO.getTests();


    }

}
