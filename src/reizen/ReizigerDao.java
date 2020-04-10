package reizen;

import java.util.ArrayList;

public interface ReizigerDao {
    public ArrayList<Reiziger> findall();
    public ArrayList<Reiziger> findbyGBdatum(String gbdatum);
    public Reiziger save(Reiziger reiziger);
    public Reiziger update(Reiziger reiziger);
    public boolean delete(Reiziger reiziger);
    public void closeconnection();

}
