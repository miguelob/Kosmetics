package servlets;

import DAO.InvoiceDAO;
import domain.Compra;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/LoadInvoices")
public class LoadInvoices extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        proccessRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        proccessRequest(request,response);
    }

    private void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Compra> compras = InvoiceDAO.getInvoices();

        request.setAttribute("invoices", compras);
        request.setAttribute("numVentas", compras.size());
        request.setAttribute("total", this.getPrecioTotal(compras));

        request.getRequestDispatcher("/info_compras.jsp").forward(request,response);
    }
    private float getPrecioTotal(ArrayList<Compra> compras){
        float total = 0;
        for(int i = 0;i<compras.size();i++){
            total += compras.get(i).getProduct().getNewPrice();
        }
        return total;
    }
}
