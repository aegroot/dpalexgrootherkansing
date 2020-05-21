package p2;

import java.sql.Date;
import java.util.ArrayList;

public class Ovchipkaart {
    private int kaartid;
    private Date geldigtot;
    private int klasse;
    private double saldo;
    private int reizigerid;
    private Reiziger reiziger;

    public Ovchipkaart(int kaartid, Date geldigtot, int klasse, double saldo) {
        this.kaartid = kaartid;
        this.geldigtot=geldigtot;
        this.klasse=klasse;
        this.saldo=saldo;


    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public int getKlasse() {
        return klasse;
    }

    public int getReizigerid() {
        return reizigerid;
    }

    public double getSaldo() {
        return saldo;
    }

    public Date getGeldigtot() {
        return geldigtot;
    }

    public int getKaartid() {
        return kaartid;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }
}
