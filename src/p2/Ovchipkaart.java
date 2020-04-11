package p2;

import java.sql.Date;

public class Ovchipkaart {
    private int kaartid;
    private Date geldigtot;
    private int klasse;
    private double saldo;
    private int reizigerid;

    public Ovchipkaart(int kaartid, Date geldigtot, int klasse, double saldo, int reizigerid) {
        this.kaartid = kaartid;
        this.geldigtot=geldigtot;
        this.klasse=klasse;
        this.saldo=saldo;
        this.reizigerid=reizigerid;
    }

    public int getKaartid() {
        return kaartid;
    }
}
