package p2;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReizigerMain {
    public static void main(String[] args) throws SQLException {
        ReizigerDaoImpl reizigerDao=new ReizigerDaoImpl();
        ArrayList<Reiziger> reizigers = new ArrayList<>(reizigerDao.findall());
        for (Reiziger i:reizigers){
            System.out.println(i.getNaam());
            ArrayList<Ovchipkaart> ovchipkaarts=i.getOvs();
            //for(Ovchipkaart o:ovchipkaarts){
             //   if (o.getKaartid()==0){
             //       System.out.println(" geen chipkaarten");
             //   }
            //    else
            //        {System.out.println(o.getKaartid());}
           // }


        }

    }
}
