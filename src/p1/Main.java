package p1;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        ArrayList<Reiziger> reizigers=new ArrayList<Reiziger>();
        ReizigerDaoImpl reizigerDao=new ReizigerDaoImpl();
        reizigers.addAll(reizigerDao.findall());
        for (Reiziger i:reizigers){
            System.out.println(i.naam);
        }

    }
}
