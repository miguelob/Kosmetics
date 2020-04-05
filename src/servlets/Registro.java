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
        String password = request.getParameter("password");
        //System.out.println(request.getParameter("password"));
        String brithDate =  request.getParameter("birthDate");
        //System.out.println(request.getParameter("birthDate"));
        String skinColor = request.getParameter("skinColor"); //this.num2SkinColor(Integer.parseInt(request.getParameter("skinColor")));
        //System.out.println(skinColor);
        String skinCondition = request.getParameter("skinCondition"); //this.num2SkinCondition(Integer.parseInt(request.getParameter("skinCondition")));
        //System.out.println(skinCondition);
        //byte[] userImg = (byte[]) ((Object) request.getParameter("userImg"));
        byte[] userImg = null;

        //ERROR CODES
        //0 --> TODO OK
        //1 --> algun campo esta vacion
        //2 --> el email ya esta registrado
        //3 --> el username ya esta registrado
        //4 --> error al gardar en base de datos

        //if(userImg == null){
           // userImg = defaultImage();
        //}

        try{
            user = new User(name,email,password,brithDate,skinColor,skinCondition,userImg,0);
            System.out.println("user");

            if(name.equals("") || email.equals("") || password.equals("") || skinColor.equals("") || skinCondition.equals("") ){//|| userImg == null){
                request.setAttribute("error",1);
                //System.out.println("nulos");
            }else if(UserDAO.getUserID(user) != -1 || UserDAO.checkUsername(user) !=-1){
                if(UserDAO.getUserID(user) != -1)
                    request.setAttribute("error",2);
                else
                    request.setAttribute("error",3);
                //System.out.println("ya existe");
            }else{
                if(!UserDAO.uploadUser(user)){
                    //System.out.println("error al subir");
                    request.setAttribute("error",4);
                }else{
                    //System.out.println("todo ok");
                    request.setAttribute("error",0);
                    request.setAttribute("user",user);
                    HttpSession session = request.getSession();
                    session.setAttribute("user",user);
                }

            }
            request.getRequestDispatcher("/index.jsp").forward(request,response);
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

