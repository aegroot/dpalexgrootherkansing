package p2;

import java.sql.*;
import java.util.ArrayList;

public class OvchipkaartDaoImpl extends OracleBaseDao implements OvchipkaartDao{
    private ArrayList<Ovchipkaart> ovchipkaarts=new ArrayList<Ovchipkaart>();

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
            ovchipkaarts.add(new Ovchipkaart(knum,geldigtot,klasse,saldo,rid));



        }


        return ovchipkaarts;
    }

    @Override
    public Reiziger save(Ovchipkaart reiziger) throws SQLException {
        return null;
    }

    @Override
    public Reiziger update(Ovchipkaart reiziger) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Ovchipkaart reiziger) throws SQLException {
        if (reiziger==null){return false;}
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
