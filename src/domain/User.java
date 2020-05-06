package domain;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;


public class User implements Serializable{

    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    private String userPassword;
    private Date birthDate;
    private String skinColor;
    private String skinCondition;
    private boolean admin;
    private boolean imagen;

    public User( String name,String email,String userPasword,
                String birthDate,String skinColor,String skinCondition,boolean admin, boolean imagen) throws ParseException {

        this.name=name;
        this.email=email;
        this.userPassword=userPasword;
        this.setBirthDate(birthDate);
        this.skinColor=skinColor;
        this.skinCondition=skinCondition;
        this.admin = admin;
        this.imagen = imagen;
        //System.out.println(admin);
    }
    public User(String name, String email, String pass){
        this.name = name;
        this.email = email;
        this.userPassword = pass;
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
    public String getIniciales(){
        String iniciales = "";
        iniciales = String.valueOf(name.charAt(0));
        if(name.contains(" ")){
            iniciales = iniciales + name.charAt(name.indexOf(" ") + 1);

        }else{
            iniciales = iniciales + name.charAt(1);
        }
        return iniciales.toUpperCase();
    }
    public int getEdad() {
        Calendar a = getCalendar(birthDate);
        Calendar b = getCalendar(new Date());
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) ||
                (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
            diff--;
        }
        return diff;
    }

    public Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public boolean isImagen() {
        return imagen;
    }
    public void setImagen(boolean status){
        this.imagen = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}