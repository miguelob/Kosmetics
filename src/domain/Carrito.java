package domain;

import java.util.HashMap;

public class Carrito {
    private static Carrito instance;
    private HashMap<Product,Integer> carrito;
    private double total;
    private int elementos;

    private Carrito(){
        this.carrito = new HashMap<Product,Integer>();
        this.total = 0;
        this.elementos = 0;
    }
    public static Carrito getInstance(){
        if(instance == null){
            instance = new Carrito();
        }
        return instance;
    }
    public HashMap<Product, Integer> getCarrito() {
        return carrito;
    }

    public double getTotal() {
        return total;
    }
    public void add(Product product, int cantidad){
        if(carrito.get(product) == null){
            carrito.put(product,cantidad);
        }
        else{
           carrito.put(product, carrito.get(product) + cantidad);
        }
        this.total = this.total + cantidad*product.getNewPrice();
        elementos += cantidad;
    }
    public void empty(){
        carrito.clear();
        total = 0;
        elementos = 0;
    }

    public int getElementos() {
        return elementos;
    }
}
