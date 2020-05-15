package p3;

import java.sql.*;
import java.util.ArrayList;

public class ProductDaoImpl extends  OracleBaseDao implements ProductDao{
    private static ArrayList<Product> products= new ArrayList<>();

    @Override
    public ArrayList<Product> findall() throws SQLException {
        Connection conn=getConnection();
        String string="select * from product";
        Statement stmt=conn.createStatement();
        ResultSet set=stmt.executeQuery(string);
        ArrayList<Product> producten=new ArrayList<Product>();
        while (set.next()){
            int nummer=set.getInt("PRODUCTNUMMER");
            String naam=set.getString("PRODUCTNAAM");
            String beschrijving=set.getString("BESCHRIJVING");
            double prijs=set.getDouble("prijs");
            producten.add(new Product(nummer,naam,beschrijving,prijs));


        }
        closeConnection();
        return producten;
    }

    @Override
    public ArrayList<Product> findbyId(String code) throws SQLException {
        return null;

    }

    @Override
    public Product save(Product product) throws SQLException {
        int nummer=product.getProductnummer();
        String naam=product.getProductnaam();
        String beschrijving=product.getBeschrijving();
        double prijs=product.getPrijs();
        Connection conn=getConnection();
        String string="insert into product(productnummer,productnaam,beschrijving,prijs) values (?,?,?,?)";
        PreparedStatement stmt=conn.prepareStatement(string);
        stmt.setInt(1,nummer);
        stmt.setString(2,naam);
        stmt.setString(3,beschrijving);
        stmt.setDouble(4,prijs);
        stmt.executeQuery();
        return product;
    }

    @Override
    public Product update(Product product) throws SQLException {
        Connection conn=getConnection();
        int nummer=product.getProductnummer();
        String naam=product.getProductnaam();
        String beschrijving=product.getBeschrijving();
        double prijs=product.getPrijs();
        String string="update product set productnummer=?,productnaam=?,beschrijving=?,prijs=? where productnummer=?";
        PreparedStatement stmt=conn.prepareStatement(string);
        stmt.setInt(1,nummer);
        stmt.setString(2,naam);
        stmt.setString(3,beschrijving);
        stmt.setDouble(4,prijs);
        stmt.setInt(5,nummer);
        stmt.executeQuery();
        closeConnection();
        return null;
    }

    @Override
    public boolean delete(Product product) throws SQLException {
        int nummer=product.getProductnummer();
        String string="delete from product where productnummer="+nummer;
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();
        ResultSet set=stmt.executeQuery(string);
        closeConnection();
        return false;
    }
}
