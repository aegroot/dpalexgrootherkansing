package reizen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao {
    String jdbcUrl="jdbc:oracle:thin:@localhost:1521:orcl";
    String dbusername="herkansing";
    String dbpassword="herkansing";
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(jdbcUrl,dbusername,dbpassword);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}