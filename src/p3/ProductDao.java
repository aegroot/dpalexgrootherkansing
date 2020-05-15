package p3;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDao {
    public ArrayList<Product> findall() throws SQLException;
    public ArrayList<Product> findbyId(String gbdatum) throws SQLException;
    public Product save(Product reiziger) throws SQLException;
    public Product update(Product reiziger) throws SQLException;
    public boolean delete(Product reiziger) throws SQLException;
}
