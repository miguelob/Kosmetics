package servlets;

import DAO.ProductDAO;
import domain.Carrito;
import domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CarritoManager")
public class CarritoManager extends HttpServlet {
    Carrito carrito = Carrito.getInstance();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = ProductDAO.getProductFromId(Integer.parseInt(request.getParameter("id")));

        if(request.getParameter("cantidad") != null){
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            carrito.add(product,cantidad);
        }else{
            carrito.add(product,1);
            request.setAttribute("carrito","Se ha añadido correctamente al carrito");
            request.getRequestDispatcher("/info_producto.jsp").forward(request,response);
        }
        if(request.getParameter("empty") != null){
            carrito.empty();
        }
    }
}
