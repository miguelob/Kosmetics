package servlets;

import DAO.ProductDAO;
import DAO.UserDAO;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@WebServlet(name = "subirImgUsuario", urlPatterns = "/subirImgUsuario")
@MultipartConfig(
        fileSizeThreshold=1024 * 1024,
        maxFileSize=1024 * 1024 * 5,
        maxRequestSize=1024 * 1024 * 5 * 5
)
public class uploadImgUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<Part> files = request.getParts();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int  idUser = UserDAO.getUserID(user);
        boolean status = false;

        for (Part f : files) {
            InputStream imagen = f.getInputStream();

            if (f.getSize() > 0) {
                status = UserDAO.uploadImg(imagen,idUser);
            }
        }
        user.setImagen(status);
        session.setAttribute("user",status);

        request.getRequestDispatcher("/editar_perfil_usuario.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
