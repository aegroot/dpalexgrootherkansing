package reizen;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ReizigerDao {
    public ArrayList<Reiziger> findall() throws SQLException;
    public ArrayList<Reiziger> findbyGBdatum(String gbdatum) throws SQLException;
    public Reiziger save(Reiziger reiziger);
    public Reiziger update(Reiziger reiziger);
    public boolean delete(Reiziger reiziger) throws SQLException;
    public void closeconnection() throws SQLException;

}
