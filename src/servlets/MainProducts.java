package servlets;

import DAO.BrandsDAO;
import DAO.FeaturesDAO;
import DAO.ProductDAO;
import DAO.QuestionsDAO;
import domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "MainProducts",urlPatterns = "/MainProducts")
public class MainProducts extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("entra a servlet MainProducts");
        HashMap<Integer,String> brands = BrandsDAO.getAllBrands();
        HashMap<Integer,String> features = FeaturesDAO.getAllFeatures();
        HashMap<Integer,String> questions = QuestionsDAO.getAllQuestions();
        ArrayList<Product> products = ProductDAO.getProductsAllInfo();
        //System.out.println("Productos cargados: "+products.size());

        HttpSession session = request.getSession();
        session.setAttribute("brands",brands);
        session.setAttribute("features",features);
        session.setAttribute("questions",questions);
        session.setAttribute("products",products);

        //System.out.println("Antes del fordward");
        response.sendRedirect("./main_product_page.jsp");
    }
}
