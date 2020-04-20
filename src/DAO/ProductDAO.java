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

    public static void getProductBasicInfo(ArrayList<Product> lista) {
        Connection con = null;
        try{
            con=ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Products");
             ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                //this will change
                lista.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6),rs.getBytes(8)));
            }

        } catch (SQLException sqle) {

            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        for(int i = 0 ; i<lista.size();i++) {
            try (PreparedStatement pst = con.prepareStatement("SELECT AVG(\"Score_Product\") FROM public.\"Reviews\" WHERE \"ID_Product\" = " + lista.get(i).getId());
                 ResultSet rs = pst.executeQuery()) {
                if(rs.next()) {
                    lista.get(i).setScore(rs.getFloat(1));
                }
            } catch (SQLException sqle) {

                System.out.println(sqle.getMessage());
            }
            //FIRST QUERY OF CHARACTERISTICS
            try (PreparedStatement pst2 = con.prepareStatement("SELECT \"Characteristic\" FROM public.\"Products\" as A1 inner join \"IDs_Prod_Charac\" as B1 on A1.\"ID_Product\" = B1.\"ID_Product\" inner join \"Characteristics\" AS c1 on B1.\"ID_Characteristic\" = C1.\"ID_Characteristic\" WHERE A1.\"ID_Product\" =" + lista.get(i).getId());
                 ResultSet rs2 = pst2.executeQuery()) {

                while (rs2.next()) {
                    lista.get(i).addFeature(rs2.getString(1));
                }

            } catch (SQLException sqle) {

                System.out.println(sqle.getMessage());
            }
        }

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


        ArrayList<Product> lista=new ArrayList<Product>();
        ProductDAO.getProductBasicInfo(lista);


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
