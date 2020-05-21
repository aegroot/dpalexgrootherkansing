package p2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class ReizigerDaoImpl  extends OracleBaseDao implements ReizigerDao {
    public static ArrayList<Reiziger> reizig=new ArrayList<Reiziger>();


    public ArrayList<Reiziger> findall() throws SQLException {
        Connection conn=getConnection();
        Statement statement=conn.createStatement();
        String string="select * from reiziger";
         ResultSet resultSet =statement.executeQuery(string);
        ArrayList<Reiziger> reizigers=new ArrayList<Reiziger>();
        while (resultSet.next()){
            int id=resultSet.getInt("reizigerid");
            String naam=(resultSet.getString("VOORLETTERS")+" "+
                    resultSet.getString("TUSSENVOEGSEL")+" "+
                    resultSet.getString("ACHTERNAAM"));
            Date datum=resultSet.getDate("GEBORTEDATUM");
            Reiziger reiziger=new Reiziger();
            reiziger.setNaam(naam);
            reiziger.getGbdatum(datum);
            reizigers.add(reiziger);
            String string1="select * from ov_chipkaart where reizigerid = ?";
            PreparedStatement statement1=conn.prepareStatement(string1);
            statement1.setInt(1,id);
            ResultSet resultSet1=statement1.executeQuery();
            while (resultSet1.next()){
                System.out.println("test");
                //Ovchipkaart kaart;
                Ovchipkaart kaart=new Ovchipkaart(
                        resultSet1.getInt(1),
                        resultSet1.getDate(2)
                        ,resultSet1.getInt(3),
                        resultSet1.getDouble(4),
                        resultSet1.getInt(5));
                        reiziger.addToOvs(kaart);
            }
        }
        reizig.addAll(reizigers);
        closeconnection();
        return reizigers;
    }

    @Override
    public ArrayList<Reiziger> findbyGBdatum(String gbdatum) throws SQLException {
        Connection conn=getConnection();
        String string="select * from reiziger where geboortedatum= ?";
        PreparedStatement stmt=conn.prepareStatement(string);
        stmt.setString(1,gbdatum);
        ResultSet set=stmt.executeQuery();
        ArrayList<Reiziger> reizigers=new ArrayList<Reiziger>();
        while (set.next()){
            String naam=(set.getString("VOORLETTERS")+" "+
                    set.getString("TUSSENVOEGSEL")+" "+
                    set.getString("ACHTERNAAM"));
            Date datum=set.getDate("GEBORTEDATUM");
            Reiziger reiziger=new Reiziger();
            reiziger.setNaam(naam);
            reiziger.setGbdatum(datum);
            reizigers.add(reiziger);

        }

        closeconnection();
        return reizigers;
    }

    @Override
    public Reiziger save(Reiziger reiziger) throws SQLException {

        Connection conn=getConnection();
        String s2="insert into ";
        String string="commit";
        PreparedStatement stmt=conn.prepareStatement(string);
        stmt.executeQuery();

        return null;
    }



    @Override
    public Reiziger update(Reiziger reiziger) throws SQLException {


        return null;
    }

    @Override
    public boolean delete(Reiziger reiziger) throws SQLException {
        if (reiziger==null){return false;}
        Connection conn=getConnection();
        String string="delete from reiziger where " +
                "voorletters = ? and achternaam =?";
        String naam=reiziger.getNaam();
        PreparedStatement stmt=conn.prepareStatement(string);
        String[] lijst=naam.split(" ");
        stmt.setString(1,lijst[0]);
        stmt.setString(2,lijst[2]);
        stmt.executeQuery();
        closeConnection();

        return true;
    }

    @Override
    public void closeconnection() throws SQLException {
        closeConnection();

    }
}
