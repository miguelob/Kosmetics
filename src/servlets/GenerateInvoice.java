package servlets;

import DAO.UserDAO;
import domain.Carrito;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTML;
import java.io.IOException;

@WebServlet("/GenerateInvoice")
public class GenerateInvoice extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Carrito carrito = (Carrito) session.getAttribute("carrito");

        UserDAO.generateInvoice(user,carrito);

        carrito.empty();
        session.setAttribute("carrito",carrito);

        response.sendRedirect("./main_product_page.jsp");
    }
}
