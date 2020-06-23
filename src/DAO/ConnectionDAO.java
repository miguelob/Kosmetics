package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
    private static ConnectionDAO instance;
    private static Connection con;
    private ConnectionDAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://kosmeticsserver.ddns.net:5432/pat_7?user=pat&password=pat");
    }
    public static ConnectionDAO getInstance() throws SQLException, ClassNotFoundException {
        if(instance == null){
            instance = new ConnectionDAO();
        }
        return instance;
    }
    public static Connection getConnection(){
        return con;
    }
}
