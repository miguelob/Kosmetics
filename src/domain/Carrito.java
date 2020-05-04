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
    public void mas1(Product product){
        if(carrito.get(product) == null){
            carrito.put(product,1);
        }
        else{
           carrito.put(product, carrito.get(product) + 1);
        }
        this.total = this.total + product.getNewPrice();
        elementos += 1;
    }
    public void menos1(Product product){
        if(carrito.get(product) == null){

        }else{
            if(carrito.get(product) -1 == 0)
                carrito.remove(product);
            else
                carrito.put(product,carrito.get(product)-1);
            this.total = this.total - product.getNewPrice();
            elementos -=1;
        }
    }
    public void empty(){
        carrito.clear();
        total = 0;
        elementos = 0;
    }
    public void eliminar(Product product){
        int cantidad = carrito.get(product);
        this.total = this.total - cantidad*product.getNewPrice();
        this.elementos -= cantidad;
        carrito.remove(product);
    }

    public int getElementos() {
        return elementos;
    }
}
