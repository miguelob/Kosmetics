package servlets;

import DAO.ProductDAO;
import DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/ReadImg")
public class ReadImg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        byte[] img = null;
        OutputStream os;

        if(request.getParameter("id") != null){
            int id = Integer.parseInt(request.getParameter("id"));
            img = ProductDAO.getProductImg(id);
        }else if(request.getParameter("name") != null){
            String name = request.getParameter("name").replace('-',' ');
            img = UserDAO.getUserImg(name);
        }
        response.setContentType("image/gif");
        os = response.getOutputStream();
        os.write(img);
        os.flush();
        os.close();


    }
}
