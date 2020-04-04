package servlets;

import DAO.UserDAO;
import domain.User;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        byte[] userImg = null;

        //ERROR CODES
        //0 --> TODO OK
        //1 --> algun campo esta vacion
        //2 --> el usuario ya existe
        //3 --> error al gardar en base de datos
        //if(userImg == null){
           // userImg = defaultImage();
        //}
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
    /*private byte[] defaultImage() throws IOException {
        BufferedImage bImage = ImageIO.read(new File("fp.jpg"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos );
        byte [] data = bos.toByteArray();
        return data;
    }*/
}
