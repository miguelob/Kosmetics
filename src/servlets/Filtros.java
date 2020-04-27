package servlets;

import DAO.BrandsDAO;
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
    Collection<Product> copy;
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
            System.out.println("ENTRA FILTRO");
            int id = Integer.parseInt(request.getParameter("Marca"));
            String marca = BrandsDAO.getBrandFromId(id);

            Cookie status = null; //new Cookie(marca.replace(' ','-'),"");
            Cookie[] cookies = request.getCookies();
            if(cookies!=null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals(marca.replace(' ','-'))) {
                        status = cookies[i];
                    }
                }
            }
            System.out.println("Despues de iterar cookies");

            if(status == null){
                System.out.println("cookie es null");
                status = new Cookie(marca.replace(' ','-'),"1");
                this.procesarFiltroMarca(marca,1);
            }else{
                System.out.println("cookie no null");
                status.setValue("");
                status.setMaxAge(0);
                procesarFiltroMarca(marca,0);
            }
            session.setAttribute("products",copy);
            System.out.println(copy);
            System.out.println("antes de añadir cookie");
            response.addCookie(status);
            request.getRequestDispatcher("./main_product_page.jsp").forward(request,response);
            //response.sendRedirect("./main_product_page.jsp");

        }
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
