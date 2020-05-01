package DAO;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;


import domain.Product;


public class ProductDAO {


    public static void uploadProduct(String name, String description, String cat, byte[] img, float price, int offer, int descuento, int idBrand) {
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
                if(rs2.next()) {
                    products.get(i).setScore(rs2.getFloat(1));
                    products.get(i).setResto();
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
    public static Product getProductFromId(int id) {
        Product product = null;
        Connection con = null;
        try{
            con=ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM products WHERE idProducts = ?");
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                //this will change
               product =new Product(rs.getInt("idProducts"), rs.getString("name"), BrandsDAO.getBrandFromId(rs.getInt("Brands_idBrands")), rs.getString("productCategory"), rs.getDouble("price"), rs.getInt("offer"),rs.getString("description"),rs.getBoolean("freeDeliver"));
                PreparedStatement pst2 = con.prepareStatement("SELECT AVG(scoreProduct) FROM reviews WHERE Products_idProducts = ?");
                pst2.setInt(1,id);
                ResultSet rs2 = pst2.executeQuery();
                if(rs2.next()) {
                    product.setScore(rs2.getFloat(1));
                    product.setResto();
                }
                PreparedStatement pst3 = con.prepareStatement("SELECT Features_idFeatures FROM products_features WHERE Products_idProducts = ?");
                pst3.setInt(1,id);
                ResultSet rs3 = pst3.executeQuery();
                while (rs3.next()) {
                    PreparedStatement pst4 = con.prepareStatement("SELECT featuresText FROM features WHERE idFeatures = ?");
                    pst4.setInt(1,rs3.getInt(1));
                    ResultSet rs4 = pst4.executeQuery();
                    while(rs4.next()) {
                        product.addFeature(rs4.getString(1));
                    }
                }
            }

        } catch (SQLException sqle) {

            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        return product;
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
//    public static int refreshScore(Product product) {
//        int valor = 0;
//        Connection con = null;
//        try {
//            con = ConnectionDAO.getInstance().getConnection();
//            PreparedStatement pst = con.prepareStatement("SELECT AVG(\"Score_Product\") FROM public.\"Reviews\" WHERE \"ID_Product\" = " + ProductDAO.getProductID(product.getName()));
//             ResultSet rs = pst.executeQuery();
//            if(rs.next()) {
//                valor = (int) rs.getFloat(1);
//                product.setScore(valor);
//            }
//        } catch (SQLException sqle) {
//            System.out.println(sqle.getMessage());
//            sqle.printStackTrace();
//        }catch (ClassNotFoundException cnfe){
//            cnfe.printStackTrace();
//        }
//        return valor;
//    }

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

    public static Product loadAllInfo(int id) {
        Product product = null;
        Connection con = null;
        try{
            con=ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM products where idProducts = ?");
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                //this will change
                product = new Product(rs.getInt("idProducts"), rs.getString("name"), BrandsDAO.getBrandFromId(rs.getInt("Brands_idBrands")), rs.getString("productCategory"), rs.getDouble("price"), rs.getInt("offer"), rs.getString("description"), rs.getBoolean("freeDeliver"));
                PreparedStatement pst2 = con.prepareStatement("SELECT AVG(scoreProduct) FROM reviews WHERE Products_idProducts = ?");
                pst2.setInt(1, id);
                ResultSet rs2 = pst2.executeQuery();
                if (rs2.next()) {
                    product.setScore(rs2.getFloat(1));
                    product.setResto();
                }
                PreparedStatement pst3 = con.prepareStatement("SELECT Features_idFeatures FROM products_features WHERE Products_idProducts = ?");
                pst3.setInt(1, id);
                ResultSet rs3 = pst3.executeQuery();
                while (rs3.next()) {
                    PreparedStatement pst4 = con.prepareStatement("SELECT featuresText FROM features WHERE idFeatures = ?");
                    pst4.setInt(1, rs3.getInt(1));
                    ResultSet rs4 = pst4.executeQuery();
                    while (rs4.next()) {
                        product.addFeature(rs4.getString(1));
                    }
                }
                PreparedStatement pst4 = con.prepareStatement("SELECT color FROM productcolor WHERE Products_idProducts = ?");
                pst4.setInt(1, id);
                ArrayList<String> colores = new ArrayList<String>();
                ResultSet rs4 = pst4.executeQuery();
                while (rs4.next()) {
                    colores.add(rs4.getString(1));
                }
                product.setColors(colores);
            }

        } catch (SQLException sqle) {

            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        SurveyDAO.getSurvey(product);
        ReviewDAO.loadProductReview(product);
        return product;
    }

    /*public static Product getProductFromId(int id) {
        Connection con = null;
        Product product = null;
        try {
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM products where idProducts = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                product = new Product(rs.getInt("idProducts"),rs.getString("name"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }*/

    public static void removeProduct(int id) {
        Connection con = null;
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://kosmeticsserver.ddns.net:5432/pat_7?user=Admin&password=Kosmetics_Admin");
            PreparedStatement pst3 = con.prepareStatement("DELETE FROM products_features WHERE Products_idProducts = ?");
            pst3.setInt(1,id);
            pst3.executeUpdate();

            PreparedStatement pst2 = con.prepareStatement("DELETE FROM products_questions WHERE Products_idProducts = ?");
            pst2.setInt(1,id);
            pst2.executeUpdate();

            PreparedStatement pst1 = con.prepareStatement("DELETE FROM reviews WHERE Products_idProducts = ?");
            pst1.setInt(1,id);
            pst1.executeUpdate();

            PreparedStatement pst4 = con.prepareStatement("DELETE FROM productcolor WHERE idproductColor = ?");
            pst4.setInt(1,id);
            pst4.executeUpdate();

            PreparedStatement pst5 = con.prepareStatement("DELETE FROM productimages WHERE idProductImg = ?");
            pst5.setInt(1,id);
            pst5.executeUpdate();

            PreparedStatement pst = con.prepareStatement("DELETE FROM products WHERE idProducts = ?");
            pst.setInt(1,id);
            pst.executeUpdate();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
    }

    public static void uploadColors(int productId, String colores) {
        Connection con = null;
        try {
            con = ConnectionDAO.getInstance().getConnection();
            String[] coloresSplit = colores.split(";");
            for (String color: coloresSplit
                 ) {
                PreparedStatement pst = con.prepareStatement("INSERT INTO productColor (color,Products_idProducts) values(?,?)");
                pst.setString(1,color);
                pst.setInt(2, productId);

                pst.executeUpdate();
            }

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            sqle.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    /*public static void getSurvey(Product product) {
        Connection con=null;
        ReviewDAO.loadProductReview(product);
        try{
            con = ConnectionDAO.getInstance().getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT Questions_idQuestion FROM  products_questions WHERE Products_idProducts = ?");
            pst.setInt(1,product.getId());
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
    }*/
}
