package servlets;

import DAO.ProductDAO;
import domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EliminarProducto", urlPatterns = "/EliminarProducto")
public class EliminarProducto extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        //System.out.println("elimina producto");
        ProductDAO.removeProduct(id);
        HttpSession session = request.getSession();
        ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("products");
        products.remove(new Product(id));;
        session.setAttribute("products",products);

        //response.sendRedirect("./main_product_page.jsp");
        request.getRequestDispatcher("./main_product_page.jsp").forward(request,response);
    }
}
