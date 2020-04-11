package p1;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class ReizigerDaoImpl  extends OracleBaseDao implements ReizigerDao{
    private ArrayList<Reiziger> reizig=new ArrayList<Reiziger>();


    public  ArrayList<Reiziger> findall() throws SQLException {
        Connection conn=getConnection();
        Statement statement=conn.createStatement();
        String string="select * from reiziger";
         ResultSet resultSet =statement.executeQuery(string);
        ArrayList<Reiziger> reizigers=new ArrayList<Reiziger>();
        while (resultSet.next()){
            String naam=(resultSet.getString("VOORLETTERS")+" "+
                    resultSet.getString("TUSSENVOEGSEL")+" "+
                    resultSet.getString("ACHTERNAAM"));
            Date datum=resultSet.getDate("GEBORTEDATUM");
            Reiziger reiziger=new Reiziger();
            reiziger.setNaam(naam);
            reiziger.getGbdatum(datum);
            reizigers.add(reiziger);
            reizig.add(reiziger);

        }

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

        return false;
    }

    @Override
    public void closeconnection() throws SQLException {
        closeConnection();

    }
}
