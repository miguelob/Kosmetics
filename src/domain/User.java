package domain;

import java.util.Date;

import javax.swing.ImageIcon;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class User implements Serializable{

    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    private String userPassword;
    private Date birthDate;
    private String skinColor;
    private String skinCondition;
    private boolean admin;

    public User( String name,String email,String userPasword,
                String birthDate,String skinColor,String skinCondition,boolean admin) throws ParseException {

        this.name=name;
        this.email=email;
        this.userPassword=userPasword;
        this.setBirthDate(birthDate);
        this.skinColor=skinColor;
        this.skinCondition=skinCondition;
        this.admin = admin;
        //System.out.println(admin);
    }

    /*public User(String name,String email,String userPasword,
            Date birthDate,String skinColor,String skinCondition, byte[] imageBytes){

			//this.idUser=idUser;
			this.name=name;
			this.email=email;
			this.password=userPasword;
			this.birthDate=birthDate;
			this.skinColor=skinColor;
			this.skinCondition=skinCondition;
			this.setImage(imageBytes);
	}*/

    public User(String name, String email, char[] userPassword){
        this.name=name;
        this.email=email;
        this.userPassword=String.valueOf(userPassword);
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return userPassword;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public String getSkinColor() {
        return skinColor;
    }
    public String getSkinCondition() {
        return skinCondition;
    }
    public void setSkinTone(String skinTone) {
        this.skinColor=skinTone;
    }
    public void setSkinCondition(String skinCondition) {
        this.skinCondition = skinCondition;
    }
    public boolean getAdmin(){
        return admin;
    }
   public void setBirthDate(String date) throws ParseException {
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       //birthDate = format.parse(date);
        birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(date));
        //System.out.println(birthDate);
        //this.birthDate = date;
    }

}