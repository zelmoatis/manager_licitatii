
package beans;


public class Licitatie {
    
    private int id_licitatie;
    private double min_increment;
    private String data_licitatie;
    private int ora;
    private boolean activa;

    public Licitatie() {
    }

    public Licitatie(int id_licitatie, String data_licitatie, int ora ) {
        this.id_licitatie = id_licitatie;
        this.min_increment = 0.05;
        this.data_licitatie = data_licitatie;
        this.ora = ora;
        this.activa = false;
    }

    public int getId_licitatie() {
        return id_licitatie;
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

    public void setId_licitatie(int id_licitatie) {
        this.id_licitatie = id_licitatie;
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
