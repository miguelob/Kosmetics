package servlets;

import DAO.UserDAO;
import domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(name = "Registro", urlPatterns = "/Registro")
public class Registro extends HttpServlet {
    private User user;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request,response); HABRA QUE PONERLO EN CUANDO EL FORWARD FUNCIONE
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String brithDate =  request.getParameter("birthDate");
        String skinColor = request.getParameter("skinColor");
        String skinCondition = request.getParameter("skinCondition");
        //byte[] userImg = (byte[]) ((Object) request.getParameter("userImg"));

        System.out.println(request.getParameter("userImg")); byte[] userImg = null;

        //ERROR CODES
        //0 --> TODO OK
        //1 --> algun campo esta vacion
        //2 --> el usuario ya existe
        //3 --> error al gardar en base de datos

        try{
            user = new User(name,email,password,brithDate,skinColor,skinCondition,userImg);

            if(name.equals("") || email.equals("") || password.equals("") || skinColor.equals("") || skinCondition.equals("") ){//|| userImg == null){
                request.setAttribute("error",1);
            }else if(UserDAO.getUserID(user) == -1){
                request.setAttribute("error",2);
            }else{
                if(!UserDAO.uploadUser(user)){
                    request.setAttribute("error",3);
                }else{
                    request.setAttribute("error",0);
                    request.setAttribute("user",user);
                    HttpSession session = request.getSession();
                    session.setAttribute("user",user);
                }

            }
            request.getRequestDispatcher("/XXXXXX.jsp").forward(request,response);//FALTA POR ESPECIFICAR EL ARCHIVO
        }catch (ParseException ex){
            ex.printStackTrace();
        }

    }
}