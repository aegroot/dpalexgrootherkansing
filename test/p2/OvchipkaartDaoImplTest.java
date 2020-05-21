package p2;

import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;


class OvchipkaartDaoImplTest {


    @Test
    void findbyreizigernotindb() {
        OvchipkaartDaoImpl ovchipkaartDao=new OvchipkaartDaoImpl();
    }

    @Test
    void findbypknotindb() {
        OvchipkaartDaoImpl ovchipkaartDao=new OvchipkaartDaoImpl();
    }

    @Test
    void deletenotindb() throws SQLException {
       LocalDate date= LocalDate.now();

        OvchipkaartDaoImpl ovchipkaartDao=new OvchipkaartDaoImpl();
        ovchipkaartDao.delete(new Ovchipkaart(11111,new Date(2020,7,2),3,100));
    }
    @Test
    void saveNotUnique(){}
}