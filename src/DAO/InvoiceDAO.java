package DAO;

import domain.Compra;
import domain.Product;
import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class InvoiceDAO {
    public static ArrayList<Compra> getInvoices() {
        ArrayList<Compra> compras = new ArrayList<Compra>();
        Connection con = null;
        //WE NEED QUERY FOR GET THE INFO WITH EACH ID
        try {
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM invoice");
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                compras.add(new Compra(ProductDAO.getProductFromId(rs.getInt(2)),UserDAO.getUser(rs.getInt(3)),rs.getString(4)));
            }
        } catch (SQLException sqle) {

            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException | ParseException cnfe){
            cnfe.printStackTrace();
        }
        return compras;
    }
}
