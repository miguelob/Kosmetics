package servlets;

import DAO.ProductDAO;
import domain.Product;
import domain.Question;
import domain.Survey;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "addProduct", urlPatterns = "/addProduct")
public class addProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println("Nombre: "+name);
        String descripcion = request.getParameter("descripcion");
        System.out.println("Descrip: "+descripcion);
        System.out.println("Categoria String: "+request.getParameter("categoria"));
        String categoria = num2Cat(Integer.parseInt(request.getParameter("categoria")));
        System.out.println("Categoria: "+categoria);
        String colores = request.getParameter("colores");
        System.out.println("Colores: "+colores);
        int marca = Integer.parseInt(request.getParameter("marca"));
        System.out.println("Marca: "+marca);
        float precio = Float.parseFloat(request.getParameter("precio"));
        System.out.println("Precio: "+precio);
        int oferta = Integer.parseInt(request.getParameter("oferta"));
        System.out.println("Oferta:" +oferta);
        int descuento = 0;
        if (oferta == 4){
            descuento = Integer.parseInt(request.getParameter("descuento"));
            System.out.println("Descuento:" +descuento);
        }

        String[] idFeatures = request.getParameterValues("features");
        ArrayList<String> features = new ArrayList<String>();
        HttpSession session = request.getSession();

        HashMap<Integer,String> brandsHM = (HashMap<Integer, String>) session.getAttribute("brands");
        HashMap<Integer,String> featuresHM = (HashMap<Integer, String>) session.getAttribute("features");
        HashMap<Integer,String> questionsHM = (HashMap<Integer, String>) session.getAttribute("questions");

        for (String feature: idFeatures) {
            features.add(featuresHM.get(Integer.parseInt(feature)));
            System.out.println("feature: "+feature);
        }
        Survey survey = new Survey();
        String[] idQuestions = request.getParameterValues("questions");
        for (String question: idQuestions) {
            int id = Integer.parseInt(question);
            survey.put(new Question(id,questionsHM.get(id)),0,0,0);
            System.out.println("Questions: "+question);
        }

        ProductDAO.uploadProduct(name,descripcion,categoria,null,precio,oferta,descuento,marca);
        int productId = ProductDAO.getProductID(name);
        if(productId != -1){
            ProductDAO.setQuestions(productId,idQuestions);
            ProductDAO.setFeatures(productId,idFeatures);
        }
        //request.getRequestDispatcher("/subirimg.jsp").forward(request,response);

    }
    private String num2Cat(int i){
        String retorno = "";
        switch (i){
            case 1:
                retorno = "bases";
                break;
            case 2:
                retorno = "máscaras de pestañas";
                break;
            case 3:
                retorno = "pintalabios";
                break;
            case 4:
                retorno = "sombras de ojos";
                break;
            case 5:
                retorno = "pestañas postizas";
                break;
            case 6:
                retorno = "contouring";
                break;
            case 7:
                retorno = "colorete";
                break;
            case 8:
                retorno = "cejas";
                break;
            case 9:
                retorno = "correctores";
                break;
            case 10:
                retorno = "eyeliner";
                break;
        }
        return  retorno;
    }
}
