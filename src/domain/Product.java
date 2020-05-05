package domain;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class Product implements Serializable{
    private static final long serialVersionUID = 1L;
    private final int id;
    private String name;
    private double ogPrice;
    private float offer;
    private double newPrice;
    private String brand;
    private String description;
    private Survey survey;
    private boolean freeDeliver;
    private ArrayList<String> features = new ArrayList<String>();
    private ArrayList<Review> reviews = new ArrayList<Review>();
    private String productCategory;
    private ArrayList<String> colors;
    private int score;
    private int resto;
    private int totalScores;
    private int numReviews;
    private float scoreFloat;
    private HashMap<Integer,Integer> parcialScores = new HashMap<Integer,Integer>();

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
    public Product(int id, String name,  String brand, String productCategory,  double ogPrice, int offer,
                   String description, boolean freeDeliver){

        this.id = id;
        this.setName(name);
        this.setOgPrice(ogPrice);
        this.setBrand(brand);
        this.setDescription(description);
        this.setProductCategory(productCategory);
        this.offer = (float) offer/100;
        this.calculateNewPrice();
        this.freeDeliver = freeDeliver;
    }

    public Product(int idProducts) {
        this.id = idProducts;
    }

    public void setResto() {
        this.resto = 5-score;
    }

    public int getResto() {
        return resto;
    }

    private void calculateNewPrice() {
        newPrice = ogPrice * (1-offer);
    }

    public boolean isFreeDeliver() {
        return freeDeliver;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public int getId() {
        return id;
    }

    public float getOffer() {
        return offer;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public String getProductCategory() {
        return productCategory;
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
    private void setOgPrice(double ogPrice) {
        if(ogPrice > 0)
            this.ogPrice = ogPrice;
        else
            this.ogPrice = 101; // to display that the price was bad registered we display 101 = LOL
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
    public void setScore(float fullscore) {
        scoreFloat = fullscore;
        score = Math.round(fullscore);
    }

    //GETTERS
    public String getName(){
        return name;
    }
    public double getOgPrice(){
        return ogPrice;
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
    /*public String getPhotoDirectory() {
    	return imageDirectory;
    }*/
    public ArrayList<Review> getReviews(){
        return reviews;
    }
    public int getScore() {
        return score;
    }
    public Survey getSurvey() {
        return survey;
    }

    public int getNumReviews() {
        return reviews.size();
    }

    public float getScoreFloat() {
        return scoreFloat;
    }
    public int getTotalScores(){
        return totalScores;
    }
    public HashMap<Integer, Integer> getParcialScores(){
        int i,valor;
        for(i=1;i<=5;i++){
            parcialScores.put(i,0);
        }
        totalScores = reviews.size();
        for(i=0; i<reviews.size();i++){
           valor = reviews.get(i).getProductScore();
           parcialScores.put(valor,parcialScores.get(valor)+1);
        }
        for(i=1; i<=5;i++){
            parcialScores.put(i,Math.round(((float)parcialScores.get(i)/totalScores)*100));
        }
        return parcialScores;
    }
    public int getParcialScoresResto(int i){
        return (100 -i);
    }


    @Override
    public String toString() {
        return "con nombre: "+this.getName()+" con precio: "+this.getOgPrice()+" con marca: "+this.getBrand()+" con Descripcion: "+this.getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId() == product.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}