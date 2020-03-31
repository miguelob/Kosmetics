package domain;

import java.util.Date;

import javax.swing.ImageIcon;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class User implements Serializable{

    private static final long serialVersionUID = 1L;
    //public final int idUser;
    private String name;
    private String email;
    byte[] userPassword;
    private Date birthDate;
    private String skinColor;
    private String skinCondition;
    private ImageIcon userImage;

    public User(String name,String email,byte[] userPasword,
                Date birthDate,String skinColor,String skinCondition, ImageIcon image){

        //this.idUser=idUser;
        this.name=name;
        this.email=email;
        this.userPassword=userPasword;
        this.birthDate=birthDate;
        this.skinColor=skinColor;
        this.skinCondition=skinCondition;
        this.userImage = image;
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

    public User(String name, String email, byte[] userPassword){
        this.name=name;
        this.email=email;
        this.userPassword = userPassword;
    }
    private void setImage(byte[] imageBytes) {
        if(imageBytes != null)
            userImage = new ImageIcon(imageBytes);
        else
            userImage = new ImageIcon("media/images/NF.jpg");
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public byte[] getPassword() {
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
    public ImageIcon getProfileImage() {
        return userImage;
    }
    public void setSkinTone(String skinTone) {
        this.skinColor=skinTone;
    }
    public void setSkinCondition(String skinCondition) {
        this.skinCondition = skinCondition;
    }
    public void setBirthDate(String date) throws ParseException {
        birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        //this.birthDate = date;
    }


}