
package beans;


public class Licitatie {
    
    private int id_produs;
    private int id_bidder;
    private int pret_curent;
    private double min_increment;
    private String data_licitatie;
    private int ora;
    private boolean activa;

    public Licitatie() {
    }

    public Licitatie(int id_produs, int id_bidder, int pret_curent,  String data_licitatie, int ora ) {
        this.id_produs = id_produs;
        this.id_bidder = id_bidder;
        this.pret_curent = pret_curent;
        this.min_increment = 0.05;
        this.data_licitatie = data_licitatie;
        this.ora = ora;
        this.activa = false;
    }

    public int getId_produs() {
        return id_produs;
    }

    public int getId_bidder() {
        return id_bidder;
    }

    public int getPret_curent() {
        return pret_curent;
    }

    public double getMin_increment() {
        return min_increment;
    }

    public String getData_licitatie() {
        return data_licitatie;
    }

    public int getOra() {
        return ora;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setId_produs(int id_produs) {
        this.id_produs = id_produs;
    }

    public void setId_bidder(int id_bidder) {
        this.id_bidder = id_bidder;
    }

    public void setPret_curent(int pret_curent) {
        this.pret_curent = pret_curent;
    }

    public void setMin_increment(int min_increment) {
        this.min_increment = min_increment;
    }

    public void setData_licitatie(String data_licitatie) {
        this.data_licitatie = data_licitatie;
    }

    public void setOra(int ora) {
        this.ora = ora;
    }

    public void setActiva(int  activa) {
        if(activa == 1)
            this.activa = true;
        else
            this.activa = false;
                  
    }
    
    
      
}
