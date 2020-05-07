package servlets;

import DAO.ReviewDAO;
import DAO.SurveyDAO;
import DAO.UserDAO;
import domain.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

@WebServlet("/creatReview")
public class creatReview extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Product product = (Product) session.getAttribute("allProduct");

        if(product != null) {
            if (user != null) {

                String comentarioTitle = request.getParameter("titulo");
                String comentario = request.getParameter("comentario");
                String scoreProduct = request.getParameter("estrellas");

                if (comentarioTitle == null || comentario == null || scoreProduct == null) {

                    request.setAttribute("error", "Debe rellenar todos los campos.");
                    request.getRequestDispatcher("./crear_review.jsp").forward(request, response);

                } else {
                    int scoreReview = 0;
                    Review review = new Review(user, Integer.parseInt(scoreProduct), scoreReview, comentario, comentarioTitle, new Date());
                    boolean correcto=ReviewDAO.uploadReview(review, product);
                    if(correcto){
                        //Cargar survey
                        SurveyDAO.getSurvey(product);
                        Survey survey = product.getSurvey();

                        for (Question q:survey.getQuestions()) {
                            System.out.println(((Integer) q.getIdQuestion()).toString());
                            String  value= request.getParameter("inlineRadioOptions@" + ((Integer) q.getIdQuestion()).toString());

                            System.out.println(value);
                            int resultado[]=survey.getQuestionRespuesta(q);
                            if(value.equals("Si")){
                                resultado[0]++;
                            }else if (value.equals("No")){
                                resultado[1]++;
                            }else if(value.equals("NS/NC")){
                                resultado[2]++;
                            }else{
                                request.setAttribute("error", "Debe responder a todas las preguntas.");
                                request.getRequestDispatcher("./crear_review.jsp").forward(request, response);
                            }

                            survey.put(q, resultado[0],resultado[1],resultado[2]);
                            System.out.println(resultado[0]+"/"+resultado[1]+"/"+resultado[2]);
                        }
                        product.setSurvey(survey);
                        correcto=SurveyDAO.uploadSurvey(product);
                        if(correcto)
                            request.getRequestDispatcher("LoadAllProduct?id="+product.getId()).forward(request, response);
                        else{
                            request.setAttribute("error", "Error en la carga de la review.");
                            request.getRequestDispatcher("./main_product_page.jsp").forward(request, response);
                        }
                    }else{
                        request.setAttribute("error", "Error en la carga de la review.");
                        request.getRequestDispatcher("./main_product_page.jsp").forward(request, response);
                    }

                }


            } else {
                System.out.println(2);
                request.setAttribute("error", "Ese necesario loguearse para crear una review.");
                request.getRequestDispatcher("./inicio_sesion_usuario.jsp").forward(request, response);

            }
        } else {
            System.out.println(1);
            request.setAttribute("error", "Ese necesario que acceda desde un producto en concreto.");
            request.getRequestDispatcher("./main_product_page.jsp").forward(request, response);
        }
    }
}
