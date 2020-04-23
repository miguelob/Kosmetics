package servlets;

import DAO.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Collectors;

@WebServlet(name = "subirImg", urlPatterns = "/subirImg")
@MultipartConfig(
        fileSizeThreshold=1024 * 1024,
        maxFileSize=1024 * 1024 * 5,
        maxRequestSize=1024 * 1024 * 5 * 5
)
public class uploadImg extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<Part> files = request.getParts();
        int id = this.getIdCookie(request);

        System.out.println(files.size());

        for (Part f : files) {
            System.out.println(f.getSubmittedFileName());

            InputStream imagen = f.getInputStream();

            System.out.println(f.getSize() + " B");

            if (f.getSize() > 0) {
                System.out.println("Se ha leído la imagen");
                int i = ProductDAO.checkImg(id);
                ProductDAO.uploadImg(id,imagen,i);
            }
        }

        //response.setStatus(200);
        //request.getRequestDispatcher("/imagen").forward(request, response);
    }

    private int getIdCookie(HttpServletRequest request) {
        Cookie id = null;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("id")) {
                    id = cookies[i];
                }
            }
        }
        return Integer.parseInt(id.getValue());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
