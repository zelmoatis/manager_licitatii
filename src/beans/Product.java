package beans;

public class Product {
	 
   private int id_produs;
   private String nume;
   private int pret_pornire;
   private String nume_vanzator;
   private String poza;
   private int id_licitatie;
   private int id_bidder;
    public Product() {
    }

    public Product(int id_produs, String nume, int pret_pornire, String nume_vanzator, String poza, int id_licitatie) {
        this.id_produs = id_produs;
        this.nume = nume;
        this.pret_pornire = pret_pornire;
        this.nume_vanzator = nume_vanzator;
        this.poza = poza;
        this.id_licitatie = id_licitatie;
    }

    public int getId_produs() {
        return id_produs;
    }

    public String getNume() {
        return nume;
    }

    public int getPret_pornire() {
        return pret_pornire;
    }

    public String getNume_vanzator() {
        return nume_vanzator;
    }

    public String getPoza() {
        return poza;
    }

    public void setId_produs(int id_produs) {
        this.id_produs = id_produs;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPret_pornire(int pret_pornire) {
        this.pret_pornire = pret_pornire;
    }

    public void setNume_vanzator(String nume_vanzator) {
        this.nume_vanzator = nume_vanzator;
    }

    public void setPoza(String poza) {
        this.poza = poza;
    }

    public int getId_licitatie() {
        return id_licitatie;
    }

    public int getId_bidder() {
        return id_bidder;
    }

    public void setId_licitatie(int id_licitatie) {
        this.id_licitatie = id_licitatie;
    }

    public void setId_bidder(int id_bidder) {
        this.id_bidder = id_bidder;
    }
   
   
	 
}