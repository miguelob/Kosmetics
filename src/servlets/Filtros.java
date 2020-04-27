package servlets;

import DAO.BrandsDAO;
import DAO.FeaturesDAO;
import DAO.ProductDAO;
import DAO.QuestionsDAO;
import domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@WebServlet("/Filtros")
public class Filtros extends HttpServlet {
    ArrayList<Product> productos;
    ArrayList<Product> copy;
    boolean start = true;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(start){
            productos = (ArrayList<Product>) session.getAttribute("products");
            copy = new ArrayList<Product>();
            //this.inicializaCokiesMarcas(request,response,session);
            start = false;
        }

        if(request.getParameter("Marca") != null){
//            System.out.println("ENTRA FILTRO");
            String formatedBrand = request.getParameter("Marca");
            //String marca = BrandsDAO.getBrandFromId(id);

            Cookie status = null; //new Cookie(marca.replace(' ','-'),"");
            Cookie[] cookies = request.getCookies();
            if(cookies!=null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals(formatedBrand)) {
                        status = cookies[i];
                    }
                }
            }
//            System.out.println("Despues de iterar cookies");

            if(status == null){
//                System.out.println("cookie es null");
                status = new Cookie(formatedBrand,"1");
                this.procesarFiltroMarca(formatedBrand.replace('-',' '),1);
            }else{
//                System.out.println("cookie no null");
                status.setValue("");
                status.setMaxAge(0);
                procesarFiltroMarca(formatedBrand.replace('-',' '),0);
            }
            session.setAttribute("products",copy);
//            System.out.println(copy);
//            System.out.println("antes de añadir cookie");
            response.addCookie(status);
            //response.sendRedirect("./main_product_page.jsp");

        }else if(request.getParameter("tipo") != null){
            String tipo = request.getParameter("tipo");
            if(session.getAttribute("products") == null)
                this.inicializaMainProductPage(request,session);
            this.searchByType(tipo.replace('-',' ').toUpperCase());
            session.setAttribute("products",copy);
        } else if(request.getParameter("feature") != null){
            String featureFormated = request.getParameter("feature");

            Cookie status = null;
            Cookie[] cookies = request.getCookies();
            if(cookies!=null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals(featureFormated)) {
                        status = cookies[i];
                    }
                }
            }

            if(status == null){
                status = new Cookie(featureFormated,"1");
                this.procesarFiltroFeature(featureFormated.replace('-',' '),1);
            }else{
                System.out.println("cookie no null");
                status.setValue("");
                status.setMaxAge(0);
                procesarFiltroFeature(featureFormated.replace('-',' '),0);
            }
            session.setAttribute("products",copy);
            response.addCookie(status);
        }
        request.getRequestDispatcher("./main_product_page.jsp").forward(request,response);


    }

    private void procesarFiltroFeature(String feature, int opc) {
        for(int i = 0;i < productos.size();i++){
            ArrayList<String> features = productos.get(i).getFeatures();
            int check = 0;
            for(int j = 0;j < features.size();j++){
                if(features.get(i).equals(feature))
                    check = 1;
            }
            if(check == 1){
                if(opc == 1){
                    if(!copy.contains(productos.get(i)))
                        copy.add(productos.get(i));
                }else{
                    if(copy.contains(productos.get(i)))
                        copy.remove(productos.get(i));
                }
            }
        }
    }

    private void searchByType(String tipo) {
        copy.clear();
        for(int i = 0;i < productos.size();i++){
            if(productos.get(i).getProductCategory().toUpperCase().equals(tipo)){
                if(!copy.contains(productos.get(i)))
                    copy.add(productos.get(i));
            }
        }
    }

    private void inicializaMainProductPage(HttpServletRequest request, HttpSession session) {
        HashMap<Integer,String> brands = BrandsDAO.getAllBrands();
        HashMap<Integer,String> features = FeaturesDAO.getAllFeatures();
        ArrayList<Product> products = ProductDAO.getProductsAllInfo();

        session = request.getSession();
        session.setAttribute("brands",brands);
        session.setAttribute("features",features);
        session.setAttribute("products",products);
    }

    private void inicializaCokiesMarcas(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        HashMap<Integer,String> marcas = (HashMap<Integer, String>) session.getAttribute("brands");
        for (String marca: marcas.values()
             ) {
            Cookie temp = new Cookie(marca.replace(' ','-'),"");
            response.addCookie(temp);
        }
    }

    private void procesarFiltroMarca(String marca,int opc){
        for(int i = 0;i < productos.size();i++){
            if(productos.get(i).getBrand().equals(marca)){
                if(opc == 1){
                    if(!copy.contains(productos.get(i)))
                        copy.add(productos.get(i));
                }else{
                    if(copy.contains(productos.get(i)))
                        copy.remove(productos.get(i));
                }
            }
        }

    }
}
