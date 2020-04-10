package reizen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao {
    static String jdbcUrl="jdbc:oracle:thin:@localhost:1521:orcl";
    static String dbusername="herkansing";
    static String dbpassword="herkansing";

    public static void getConnection(){
    {
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl,dbusername,dbpassword);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}


}