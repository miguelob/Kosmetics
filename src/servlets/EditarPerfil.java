package servlets;

import DAO.UserDAO;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;

@WebServlet("/EditarPerfil")
public class EditarPerfil extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request,response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request,response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if(request.getParameter("btn").equals("first")){
//            System.out.println("entra");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");

            User temp = new User(name,email,pass);

            if(user.getName() != name){
                if(UserDAO.checkUsername(temp) != -1){
                    request.setAttribute("error","Ese nombre de usuario ya existe.");
                    request.getRequestDispatcher("./editar_perfil_usuario.jsp").forward(request,response);
                }
            }else if(user.getEmail() != email){
                if(UserDAO.checkEmail(temp) != -1){
                    request.setAttribute("error","Ese email ya existe.");
                    request.getRequestDispatcher("./editar_perfil_usuario.jsp").forward(request,response);
                }
            }
            boolean status = UserDAO.editUser1(user.getName(),temp);
//            System.out.println("Estado upload: "+status);
            if(!status){
                request.setAttribute("error1","Error al actualizar, inténtelo de nuevo.");
                request.getRequestDispatcher("./editar_perfil_usuario.jsp").forward(request,response);
            }else{
                temp = UserDAO.getUser(UserDAO.getUserID(temp));
                session.setAttribute("user",temp);
                response.sendRedirect("./LoadAllUser");
            }


        }else if(request.getParameter("btn").equals("second")){
            String skinColor = this.num2SkinColor(Integer.parseInt(request.getParameter("skinColor")));
            String skinCondition = this.num2SkinColor(Integer.parseInt(request.getParameter("skinCondition")));
            String bday = request.getParameter("fecha_nacimiento");
            String genero = this.num2genero(Integer.getInteger(request.getParameter("genero")));
            String direccion = request.getParameter("direccion");

            boolean status = UserDAO.editUser2(user.getName(),bday,skinColor,skinCondition);
            if(!status){
                request.setAttribute("error","Error al actualizar, inténtelo de nuevo.");
                request.getRequestDispatcher("./editar_perfil_usuario.jsp").forward(request,response);
            }else{
                User temp = UserDAO.getUser(UserDAO.getUserID(user));
                session.setAttribute("user",temp);
                response.sendRedirect("./LoadAllUser");
            }
        }


    }

    private String num2genero(Integer genero) {
        String retorno = "";
        switch (genero){
            case 1:
                retorno = "Mujer";
                break;
            case 2:
                retorno = "Hombre";
                break;
            case 3:
                retorno = "Prefiero no decirlo";
                break;
            case 4:
                retorno = "Otro";
                break;
        }
        return retorno;
    }

    private String num2SkinColor(int i){
        String retorno = "";
        switch (i){
            case 1:
                retorno = "marfil";
                break;
            case 2:
                retorno = "palida";
                break;
            case 3:
                retorno = "beige";
                break;
            case 4:
                retorno = "moreno claro";
                break;
            case 5:
                retorno = "moreno oscuro";
                break;
        }
        return retorno;
    }
    private String num2SkinCondition(int i){
        String retorno = "";
        switch (i){
            case 1:
                retorno = "mixta";
                break;
            case 2:
                retorno = "grasa";
                break;
            case 3:
                retorno = "seca";
                break;
        }
        return retorno;
    }
}
