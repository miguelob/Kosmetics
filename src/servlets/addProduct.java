package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addProduct", urlPatterns = "/addProduct")
public class addProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        System.out.println(name);
        String descripcion = request.getParameter("descripcion");
        System.out.println(descripcion);
        String categoria = request.getParameter("categoria");
        System.out.println(categoria);
        String colores = request.getParameter("colores");
        System.out.println(colores);
        String marca = request.getParameter("marca");
        System.out.println(marca);
        float precio = Float.parseFloat(request.getParameter("precio"));
        String oferta = request.getParameter("oferta");
        System.out.println(oferta);
        String[] features = request.getParameterValues("features");
        for (String feature: features) {
            System.out.println(feature);
        }
        String[] questions = request.getParameterValues("questions");
        for (String question: questions) {
            System.out.println(question);
        }



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
