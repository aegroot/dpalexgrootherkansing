package p2;

import java.sql.*;
import java.util.ArrayList;

public class OvchipkaartDaoImpl extends OracleBaseDao implements OvchipkaartDao{
    private static ArrayList<Ovchipkaart> ovchipkaarten=new ArrayList<Ovchipkaart>();

    @Override
    public ArrayList<Ovchipkaart> findall() throws SQLException {
        Connection conn=getConnection();
        Statement statement=conn.createStatement();
        String string="select * from ov_chipkaart";
        ResultSet resultSet =statement.executeQuery(string);
        ArrayList<Ovchipkaart> ovchipkaarts=new ArrayList<Ovchipkaart>();
        while (resultSet.next()){
            int knum=resultSet.getInt("kaartnummer");
            Date geldigtot=resultSet.getDate("geldigtot");
            int klasse=resultSet.getInt("klasse");
            double saldo=resultSet.getDouble("saldo");
            int rid=resultSet.getInt("reizigerid");
            Ovchipkaart ovchipkaart=new Ovchipkaart(knum,geldigtot,klasse,saldo);

            String string1="select * from reiziger where reizigerid = ?";
            PreparedStatement statement1=conn.prepareStatement(string1);
            statement1.setString(1, String.valueOf(knum));
            ResultSet resultSet1=statement1.executeQuery();
            while (resultSet1.next()){
                String naam=(resultSet1.getString("VOORLETTERS")+" "+
                        resultSet1.getString("TUSSENVOEGSEL")+" "+
                        resultSet1.getString("ACHTERNAAM"));
                java.util.Date datum=resultSet1.getDate("GEBORTEDATUM");
                Reiziger reiziger=new Reiziger();
                reiziger.setNaam(naam);
                reiziger.setGbdatum(datum);
                reiziger.addToOvs(ovchipkaart);
                ovchipkaart.setReiziger(reiziger);
                ovchipkaarts.add(ovchipkaart);
            }
        }
        ovchipkaarten.addAll(ovchipkaarts);
        closeConnection();
        return ovchipkaarts;

    }



    public Ovchipkaart findbyreiziger(Reiziger reiziger) throws SQLException {
        OvchipkaartDaoImpl ovchipkaartDao=new OvchipkaartDaoImpl();
        ArrayList<Ovchipkaart> ovchipkaarts=ovchipkaartDao.findall();
        for (Ovchipkaart ovchip:ovchipkaarts) {
            if(reiziger==ovchip.getReiziger()){
                return ovchip;
            }

        }
        return null;

    }


    public Ovchipkaart findbypk(int nummer) throws SQLException {
        Connection conn=getConnection();
        Statement statement=conn.createStatement();
        String string="select * from ov_chipkaart";
        ResultSet resultSet =statement.executeQuery(string);
        ArrayList<Ovchipkaart> ovchipkaarts=new ArrayList<Ovchipkaart>();
        while (resultSet.next()){
            int knum=resultSet.getInt("kaartnummer");
            Date geldigtot=resultSet.getDate("geldigtot");
            int klasse=resultSet.getInt("klasse");
            double saldo=resultSet.getDouble("saldo");
            int rid=resultSet.getInt("reizigerid");
            Ovchipkaart ovchipkaart=new Ovchipkaart(knum,geldigtot,klasse,saldo);
            ovchipkaarts.add(ovchipkaart);
        }
        for (Ovchipkaart ov:ovchipkaarts) {
            if (ov.getKaartid()==nummer){
                return ov;
            }

        }
        return null;}

    @Override
    public Ovchipkaart save(Ovchipkaart reiziger) throws SQLException {
        Connection conn=getConnection();
        String string1="insert into OV_CHIPKAART(kaartnummer,geldigtot,klasse,saldo,reizigerid) VALUES (?,?,?,?,?)";
        PreparedStatement statement1=conn.prepareStatement(string1);
        statement1.setInt(1, reiziger.getKaartid());
        statement1.setDate(2,reiziger.getGeldigtot());
        statement1.setInt(3,reiziger.getKlasse());
        statement1.setDouble(4,reiziger.getSaldo());
        statement1.setInt(5,reiziger.getReizigerid());
        statement1.executeQuery();
        return reiziger;
    }

    @Override
    public Ovchipkaart update(Ovchipkaart reiziger) throws SQLException {
        Connection conn=getConnection();
        String string1="update OV_CHIPKAART set kaartnummer=?,geldigtot=?,klasse=?,saldo=?,reizigerid=? where kaartnummer=?";
        PreparedStatement statement1=conn.prepareStatement(string1);
        statement1.setInt(1, reiziger.getKaartid());
        statement1.setDate(2,reiziger.getGeldigtot());
        statement1.setInt(3,reiziger.getKlasse());
        statement1.setDouble(4,reiziger.getSaldo());
        statement1.setInt(5,reiziger.getReizigerid());
        statement1.setInt(5,reiziger.getKaartid());
        statement1.executeQuery();
        return reiziger;
    }

    @Override
    public boolean delete(Ovchipkaart reiziger) throws SQLException {

        OvchipkaartDaoImpl ovchipkaartDao=new OvchipkaartDaoImpl();
        ArrayList<Ovchipkaart> ovchipkaarts=ovchipkaartDao.findall();
        if (reiziger==null){return false;}
        if(!ovchipkaarts.contains(reiziger)){return false;}
        Connection conn=getConnection();
        String string="delete from ov_chipkaart where " +
                "kaartnummer = ?";
        int naam=reiziger.getKaartid();
        PreparedStatement stmt=conn.prepareStatement(string);
        stmt.setString(1, String.valueOf(naam));
        stmt.executeQuery();
        closeConnection();

        return true;
    }

    @Override
    public void closeconnection() throws SQLException {

    }


}
