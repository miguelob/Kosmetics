package servlets;

import DAO.ReviewDAO;
import DAO.UserDAO;
import domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoadAllUser")
public class LoadAllUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//       System.out.println("entra");
        if(request.getParameter("name") != null){
            String name = request.getParameter("name").replace('-',' ');
//            System.out.println("entra");
            int id = UserDAO.getUserIDFromName(name);
            if(id != -1){
                User user = UserDAO.getUser(id);
                request.setAttribute("user",user);
                request.setAttribute("reviews",ReviewDAO.getAllUserReviews(user));
                request.setAttribute("compras", UserDAO.getCompras(user));
            }

        }else{
            HttpSession session = request.getSession();
            request.setAttribute("user",session.getAttribute("user"));
//        System.out.println(ReviewDAO.getAllUserReviews((User) session.getAttribute("user")));
            request.setAttribute("reviews",ReviewDAO.getAllUserReviews((User) session.getAttribute("user")));
            request.setAttribute("compras", UserDAO.getCompras((User) session.getAttribute("user")));
        }
        //response.sendRedirect("./info_usuario.jsp");
        request.getRequestDispatcher("./info_usuario.jsp").forward(request,response);
    }
}
