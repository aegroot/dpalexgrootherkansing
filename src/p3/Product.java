package p3;

public class Product {
    private int productnummer;
    private String productnaam;
    private String beschrijving;
    private double prijs;

    public Product(int productnummer,String productnaam,
                   String beschrijving,double prijs) {
    }

    public int getProductnummer() {
        return productnummer;
    }

    public String getProductnaam() {
        return productnaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }
}
