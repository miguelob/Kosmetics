package servlets;

import DAO.ProductDAO;
import domain.Product;

import javax.management.DynamicMBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoadAllProduct")
public class LoadAllProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int id = 0;
        Product product = null;

        if(request.getParameter("opc") != null){
            product = (Product) session.getAttribute("allProduct");

            session.setAttribute("allProduct",ProductDAO.loadAllInfo(product.getId()));
            request.getRequestDispatcher("/crear_review.jsp").forward(request,response);

        }else if(request.getParameter("id") != null){
            id = Integer.parseInt(request.getParameter("id"));
            product = ProductDAO.loadAllInfo(id);
            session.setAttribute("allProduct",product);

            request.getRequestDispatcher("/info_producto.jsp").forward(request,response);
        }
    }
}
