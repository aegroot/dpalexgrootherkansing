package p2;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OvchipkaartDao {
    public ArrayList<Ovchipkaart> findall() throws SQLException;
    public Ovchipkaart save(Ovchipkaart reiziger) throws SQLException;
    public Ovchipkaart update(Ovchipkaart reiziger) throws SQLException;
    public boolean delete(Ovchipkaart reiziger) throws SQLException;
    public void closeconnection() throws SQLException;
}
