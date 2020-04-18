package servlets;

import DAO.BrandsDAO;
import DAO.FeaturesDAO;
import DAO.QuestionsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "CargarDatosMarcas", urlPatterns = "/CargarDatosMarcas")
public class CargarDatosMarcas extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<Integer,String> brands = BrandsDAO.getAllBrands();
        HashMap<Integer,String> features = FeaturesDAO.getAllFeatures();
        HashMap<Integer,String> questions = QuestionsDAO.getAllQuestions();

        HttpSession session = request.getSession();
        session.setAttribute("brands",brands);
        session.setAttribute("features",features);
        session.setAttribute("questions",questions);

        request.getRequestDispatcher("/incluir_producto.jsp").forward(request,response);
    }
}
