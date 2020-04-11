package reizen;

import java.util.Date;

public class Reiziger {
    String naam;
    Date gbdatum;


    public Reiziger() {
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
