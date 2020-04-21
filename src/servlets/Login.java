package servlets;

import DAO.UserDAO;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("entra a servlet login");
        String email = request.getParameter("userOrEmail");
        String password = request.getParameter("password");

        if(!email.equals("") || !password.equals("")){
            User user = UserDAO.login(email,password);
            if(user != null){
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                //System.out.println("Todo OK");
                request.getRequestDispatcher("MainProducts").forward(request,response);
            }else{
                request.setAttribute("error","Contraseña o email incorrectos");
                request.getRequestDispatcher("/inicio_sesion_usuario.jsp").forward(request,response);
            }

        }else{
            request.setAttribute("error","Debe rellenar todos los campos");
            request.getRequestDispatcher("/inicio_sesion_usuario.jsp").forward(request,response);
        }
    }
}
