package servlets;

import DAO.ProductDAO;
import domain.Carrito;
import domain.Product;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "CarritoManager", urlPatterns = "/CarritoManager")
public class CarritoManager extends HttpServlet {
    Carrito carrito = Carrito.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if(request.getParameter("empty") != null){
            carrito.empty();
            session.setAttribute("carrito",null);
        }else if(request.getParameter("sumaInfo") != null) {
            carrito.mas1((Product) session.getAttribute("allProduct"));
            request.setAttribute("mensaje","Se ha añadido al carrito correctamente.");
            session.setAttribute("carrito",carrito);
            request.getRequestDispatcher("./info_producto.jsp").forward(request,response);
        }else{
            Product product = ProductDAO.getProductFromId(Integer.parseInt(request.getParameter("id")));

            if(request.getParameter("eliminar") != null){
                carrito.eliminar(product);
            }else if(request.getParameter("suma") != null) {
                carrito.mas1(product);
            }else if(request.getParameter("resta") != null) {
                carrito.menos1(product);
            }
            session.setAttribute("carrito",carrito);
            request.getRequestDispatcher("/carrito.jsp").forward(request,response);
        }
    }
}
