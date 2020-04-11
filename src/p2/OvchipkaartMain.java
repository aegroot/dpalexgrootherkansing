package p2;

import java.sql.SQLException;
import java.util.ArrayList;

public class OvchipkaartMain {
    public static void main(String[] args) throws SQLException {
        OvchipkaartDaoImpl ovchipkaartDao=new OvchipkaartDaoImpl();
        ArrayList<Ovchipkaart> ovchipkaarts=ovchipkaartDao.findall();
        for (Ovchipkaart i:ovchipkaarts){System.out.println(i.getKaartid());}

    }
}
