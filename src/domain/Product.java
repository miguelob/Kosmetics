package domain;

import javax.swing.*;
import java.awt.*;

public class Product {
    private String name;
    private String description;
    private String category;
    private ImageIcon image;
    private float price;
    private int offer;

    public Product(String name, String description, String category, byte[] image, float price, int offer){
        this.name = name;
        this.description = description;
        this.category = category;
        this.convertImage(image);
        this.calculatePrice(price,offer);

    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public String getCategory(){
        return category;
    }
    public ImageIcon getImage(){
        return image;
    }
    public float getPrice(){
        return price;
    }

    private void convertImage(byte[] image){
        if(image != null)
            this.image = new ImageIcon(image);
        else
            this.image = new ImageIcon("media/images/NF.jpg");
    }
    private void calculatePrice(float price, int offer){
        if(offer >= 0 && offer <= 100){
            this.price = price*(1-(offer/100));
        }else{
            this.price = price;
        }
    }
}
