package p3;

import java.util.ArrayList;
import java.util.Date;

public class Reiziger {
    private ArrayList<Ovchipkaart> ovs;
    String naam;
    Date gbdatum;

    public void addToOvs(Ovchipkaart ov) {
        ovs.add(ov);
    }

    public Reiziger() {
    }

    public ArrayList<Ovchipkaart> getOvs() {
        return ovs;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Date getGbdatum(Date datum) {
        return gbdatum;
    }

    public void setGbdatum(Date gbdatum) {
        this.gbdatum = gbdatum;
    }

    public String getNaam() {
        return naam;
    }

}
