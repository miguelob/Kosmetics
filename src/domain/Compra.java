package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Compra {
    private Product product;
    private User user;
    private Date date;

    public Compra(Product product, User user, String date) throws ParseException {
        this.product = product;
        this.user = user;
        this.setDate(date);
    }

    public Product getProduct() {
        return product;
    }

    public String date2string(){
        String og = date.toString().replace("00:00:00 CEST ", "");

        return og;
    }

    public User getUser() {
        return user;
    }
    private void setDate(String date) throws ParseException {
        this.date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(date));
    }
}
