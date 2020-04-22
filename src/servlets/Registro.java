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
        processRequest(request,response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        //System.out.println(request.getParameter("name"));
        String email = request.getParameter("email");
        //System.out.println(request.getParameter("email"));
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        //System.out.println("1: "+password1+" 2: "+password2);
        //System.out.println(request.getParameter("password"));
        String brithDate =  request.getParameter("birthDate");
        //System.out.println(request.getParameter("birthDate"));
        String skinColor = request.getParameter("skinColor"); //this.num2SkinColor(Integer.parseInt(request.getParameter("skinColor")));
        //System.out.println(skinColor);
        String skinCondition = request.getParameter("skinCondition"); //this.num2SkinCondition(Integer.parseInt(request.getParameter("skinCondition")));
        //System.out.println(skinCondition);
        //byte[] userImg = (byte[]) ((Object) request.getParameter("userImg"));
        HttpSession session = request.getSession();

        //ERROR CODES
        //0 --> TODO OK
        //1 --> algun campo esta vacion
        //2 --> el email ya esta registrado
        //3 --> el username ya esta registrado
        //4 --> error al gardar en base de datos

        //if(userImg == null){
           // userImg = defaultImage();
        //}

        if(password1.equals(password2)){
            try{
                user = new User(name,email,password1,brithDate,skinColor,skinCondition,false);
                //System.out.println("user");

                if(name.equals("") || email.equals("") || password1.equals("") || skinColor.equals("") || skinCondition.equals("") ){//|| userImg == null){
                    request.setAttribute("error","Rellene todos los campos.");
                    request.getRequestDispatcher("/registro_usuario.jsp").forward(request,response);
                    System.out.println("nulos");
                }else if(UserDAO.getUserID(user) != -1 || UserDAO.checkUsername(user) !=-1 || UserDAO.checkEmail(user) != 1){
                    if (UserDAO.checkUsername(user) != -1)
                        request.setAttribute("error","Ese nombre de usuario ya está registrado.");
                    else
                        request.setAttribute("error","Ese email ya está registrado.");
                    //System.out.println("ya existe");
                    request.getRequestDispatcher("/registro_usuario.jsp").forward(request,response);
                }else{
                    if(!UserDAO.uploadUser(user)){
                        //System.out.println("error al subir");
                        request.setAttribute("error","Error al subir el usuario.");
                        request.getRequestDispatcher("/registro_usuario.jsp").forward(request,response);
                    }else{
                        //System.out.println("todo ok");
                        session.setAttribute("user",user);
                        request.getRequestDispatcher("/MainProducts").forward(request,response);
                    }

                }
            }catch (ParseException ex){
                ex.printStackTrace();
            }
        }else{
            //System.out.println("Contraseñas no coinciden");
            request.setAttribute("eror","Las contraseñas no coinciden.");
            request.getRequestDispatcher("/registro_usuario.jsp").forward(request,response);
        }

    }
    /*private byte[] defaultImage() throws IOException {
        BufferedImage bImage = ImageIO.read(new File("fp.jpg"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos );
        byte [] data = bos.toByteArray();
        return data;
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
    }*/
}

