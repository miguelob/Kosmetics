package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.io.Serializable;
import javax.swing.ImageIcon;

public class Product implements Serializable{
    private static final long serialVersionUID = 1L;
    public final int idProduct;
    private String name;
    private double price;
    private String brand;
    private String description;
    private Survey survey;
    private ArrayList<String> features = new ArrayList<String>();
    private ArrayList<Review> reviews = new ArrayList<Review>();
    private String productCategory;
    private ArrayList<ImageIcon> productImages;
    private ArrayList<String> colors;
    private int score;

    //NUEVO CONTRUSCOTOR PARA AÑADIR NUEVO PRODUCTO


    //Constructor with all the information-> No tiene sentido, cuando el usuario requiera ás info del producto se carga sobre el ya existente.
   /* public Product(int idProduct, String name, String productCategory, double price,
        String brand, String description, String imageDirectory ,Survey survey, ArrayList<String> features,
         ArrayList<Review> reviews){

        this.idProduct = idProduct;
        this.setName(name);
        this.setPrice(price);
        this.setBrand(brand);
        this.setDescription(description);
        this.setProductCategory(productCategory);
        this.survey = survey;
        this.features = features;
        this.reviews = reviews;
        this.imageDirectory = imageDirectory;
        this.setImage();
    }*/

    //Constructor with the basic information to show on the main screen
    public Product(int idProduct, String productCategory, String name,  String brand, double price,
                   String description, byte[] imageBytes){

        this.idProduct = idProduct;
        this.setName(name);
        this.setPrice(price);
        this.setBrand(brand);
        this.setDescription(description);
        this.setProductCategory(productCategory);
        this.setImage(imageBytes);
    }
    //===================================ESTE BORRAR===========================================================0
    //TEMPORAL CONSTRUCTOR TO CHECK PROGRESS
    public Product(int idProduct, String productCategory, String name,  String brand, double price, String description){

        this.idProduct = idProduct;
        this.setName(name);
        this.setPrice(price);
        this.setBrand(brand);
        this.setDescription(description);
        this.setProductCategory(productCategory);
    }


    public void setSurvey(Survey survey){
        this.survey=survey;
    }

    //Tanto reviews como features se rellenan una a una
    public void addReview(Review review){
        reviews.add(review);
    }

    public void addFeature(String feature){
        features.add(feature);
    }

    //setters
    private void setName(String name) {
        if(name != null)
            this.name = name;
        else
            this.name = "EMPTY_FIELD"; // to display that the name is empty
    }
    private void setPrice(double price) {
        if(price > 0)
            this.price = price;
        else
            this.price = 101; // to display that the price was bad registered we display 101 = LOL
    }
    private void setBrand(String brand) {
        if(brand != null)
            this.brand = brand;
        else
            this.brand = "EMPTY_FIELD"; // to display that the brand is empty
    }
    private void setDescription(String description) {
        if(description != null)
            this.description = description;
        else
            this.description = "EMPTY_FIELD"; // to display that the description is empty
    }
    private void setProductCategory(String productCategory) {
        if(productCategory != null)
            this.productCategory = productCategory;
        else
            this.productCategory = "EMPTY_FIELD"; // to display that the category is empty
    }
    private void setImage(byte[] imageBytes) {
        if(imageBytes != null)
            productImages.add(new ImageIcon(imageBytes));
        else
            productImages.add(new ImageIcon("media/images/NF.jpg"));
    }
    public void setScore(float fullscore) {
        score = Math.round(fullscore);
    }

    //GETTERS
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public String getBrand(){
        return brand;
    }
    public String getDescription(){
        return description;
    }
    public String getCategory(){
        return productCategory;
    }
    public ArrayList<String> getFeatures(){
        return features;
    }
    public int getId() {
        return idProduct;
    }
    /*public String getPhotoDirectory() {
    	return imageDirectory;
    }*/
    public ImageIcon getProductImage() {
        return productImages.get(0);
    }
    public ArrayList<Review> getReviews(){
        return reviews;
    }
    public int getScore() {
        return score;
    }
    public Survey getSurvey() {
        return survey;
    }
    @Override
    public String toString() {
        return "He leido el id: "+this.getId()+" con nombre: "+this.getName()+" con precio: "+this.getPrice()+" con marca: "+this.getBrand()+" con Descripcion: "+this.getDescription();
    }

}