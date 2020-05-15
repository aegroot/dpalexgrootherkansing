package p3;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReizigerDao {
    public ArrayList<Reiziger> findall() throws SQLException;
    public ArrayList<Reiziger> findbyGBdatum(String gbdatum) throws SQLException;
    public Reiziger save(Reiziger reiziger) throws SQLException;
    public Reiziger update(Reiziger reiziger) throws SQLException;
    public boolean delete(Reiziger reiziger) throws SQLException;
    public void closeconnection() throws SQLException;

}
