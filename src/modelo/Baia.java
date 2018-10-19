package modelo;

public class Baia {
   private int id;
   private double tam;
   private boolean limp = true;

    public Baia(int id, double tam, boolean limp) {
        this.id = id;
        this.tam = tam;
        this.limp = limp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTam() {
        return tam;
    }

    public void setTam(double tam) {
        this.tam = tam;
    }

    public boolean isLimp() {
        return limp;
    }

    public void setLimp(boolean limp) {
        this.limp = limp;
    }
  @Override
    public String toString() {
        return "Baia " + id ;
    }  

    
}
