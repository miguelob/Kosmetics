package DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import domain.Product;


public class ProductDAO {

    public static void uploadProduct(String name, String description, String cat, byte[] img, float price, int offer,int descuento, int idBrand) {
        Connection con=null;
        int oferta = 0;
        int freeD = 0;
        switch (offer){
            case 2 :
                freeD = 1;
                break;
            case 3:
                oferta = 100;
                break;
            case 4:
                oferta = descuento;
                break;
        }
        try{
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("INSERT INTO products (name,description,productCategory,productImg,price,offer,freeDeliver,Brands_idBrands) VALUES(?,?,?,?,?,?,?,?)");
            pst.setString(1,name);
            pst.setString(2,description);
            pst.setString(3,cat);
            pst.setBytes(4,null);
            pst.setFloat(5,price);
            pst.setInt(6,oferta);
            pst.setInt(7,freeD);
            pst.setInt(8,idBrand);

            pst.executeUpdate();

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
    }
    public static void setQuestions(int productId, String[] idQuestions){
        Connection con = null;
        try{
            con = ConnectionDAO.getInstance().getConnection();
            for (String question: idQuestions) {

                int questionId = Integer.parseInt(question);
                PreparedStatement pst = con.prepareStatement("INSERT INTO products_questions (Products_idProducts,Questions_idQuestion) VALUES(?,?)");
                pst.setInt(1,productId);
                pst.setInt(2,questionId);

                pst.executeUpdate();
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
    }
    public static void setFeatures(int productId, String[] idFeatures){
        Connection con = null;
        try{
            con = ConnectionDAO.getInstance().getConnection();
            for (String feature: idFeatures) {

                int featureId = Integer.parseInt(feature);
                PreparedStatement pst = con.prepareStatement("INSERT INTO products_features (Products_idProducts,Features_idFeatures) VALUES(?,?)");
                pst.setInt(1,productId);
                pst.setInt(2,featureId);

                pst.executeUpdate();
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
    }
    public static int getProductID(String name) {
        int id = -1;
        Connection con=null;
        try {
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT idProducts FROM  products WHERE name = ?");
            pst.setString(1,name);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        return id;
    }

    public static ArrayList<Product> getProductsAllInfo() {
        ArrayList<Product> products = new ArrayList<Product>();
        int i = 0;
        Connection con = null;
        try{
            con=ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM products");
             ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                //this will change
                products.add(new Product(rs.getInt("idProducts"), rs.getString("name"), BrandsDAO.getBrandFromId(rs.getInt("Brands_idBrands")), rs.getString("productCategory"), rs.getDouble("price"), rs.getInt("offer"),rs.getString("description"),rs.getBoolean("freeDeliver")));
                PreparedStatement pst2 = con.prepareStatement("SELECT AVG(scoreProduct) FROM reviews WHERE Products_idProducts = ?");
                pst2.setInt(1,products.get(i).getId());
                ResultSet rs2 = pst2.executeQuery();
                if(rs.next()) {
                    products.get(i).setScore(rs.getFloat(1));
                }
                PreparedStatement pst3 = con.prepareStatement("SELECT Features_idFeatures FROM products_features WHERE Products_idProducts = ?");
                pst3.setInt(1,products.get(i).getId());
                ResultSet rs3 = pst3.executeQuery();
                while (rs3.next()) {
                    PreparedStatement pst4 = con.prepareStatement("SELECT featuresText FROM features WHERE idFeatures = ?");
                    pst4.setInt(1,rs3.getInt(1));
                    ResultSet rs4 = pst4.executeQuery();
                    while(rs4.next()) {
                        products.get(i).addFeature(rs4.getString(1));
                    }
                }
                i++;
            }

        } catch (SQLException sqle) {

            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        return products;
    }
    public static void getProductFullInfo(Product product) {
        Connection con=null;
        ReviewDAO.loadProductReview(product);
        //FALTA RELLENAR LAS IMAGENES QUE FALTAN
        //QUERY PARA SACAR EL ID DE ENCUESTA ASOCIADA AL PRODUCTO
        try{
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT \"ID_Survey\" FROM  \"Products\" WHERE \"ID_Product\" = " + product.getId());
             ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                product.setSurvey(SurveyDAO.getSurvey(rs.getInt(1)));
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
    }
    public static int getSurveyID(Product product) {
        int id = -1;
        Connection con = null;
        try{
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT \"ID_Survey\" FROM  \"Products\" WHERE \"Name\" = '" + product.getName()+"'");
             ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        }catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        return id;
    }
    public static int refreshScore(Product product) {
        int valor = 0;
        Connection con = null;
        try {
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT AVG(\"Score_Product\") FROM public.\"Reviews\" WHERE \"ID_Product\" = " + ProductDAO.getProductID(product.getName()));
             ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                valor = (int) rs.getFloat(1);
                product.setScore(valor);
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        }catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        return valor;
    }


    public static void main(String[] args) {


        ArrayList<Product> lista = ProductDAO.getProductsAllInfo();


        for (Product producto : lista) {
            System.out.println(producto);
        }


    }

    public static void uploadImg(int id, InputStream imagen,int i) {
        Connection con = null;
        if(i==0){
            try {
                con = ConnectionDAO.getInstance().getConnection();
                PreparedStatement pst = con.prepareStatement("UPDATE products SET productImg = ? WHERE idProducts = ?");
                pst.setBlob(1, imagen);
                pst.setInt(2, id);

                pst.executeUpdate();

            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
                sqle.printStackTrace();
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
        }else{
            try {
                con = ConnectionDAO.getInstance().getConnection();
                PreparedStatement pst = con.prepareStatement("INSERT INTO productimages (productImg,Products_idProducts) values(?,?)");
                pst.setBlob(1, imagen);
                pst.setInt(2, id);

                pst.executeUpdate();

            } catch (SQLException sqle) {
                System.out.println(sqle.getMessage());
                sqle.printStackTrace();
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
        }
    }

    public static int checkImg(int id) {
        Connection con = null;
        int retorno = 0;
        try {
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT productImg FROM products WHERE idProducts = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                if(rs.getBlob(1)!= null){
                    retorno = 1;
                }
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return retorno;
    }

    public static byte[] getProductImg(int id) {
        byte[] retorno = null;
        Connection con = null;
        try {
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT productImg FROM products WHERE idProducts = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                retorno = rs.getBytes(1);
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return retorno;
    }
}
