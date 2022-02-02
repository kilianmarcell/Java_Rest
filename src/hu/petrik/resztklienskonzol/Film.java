package hu.petrik.resztklienskonzol;

public class Film {
    private int id, hossz, ertekeles;
    private String cim, kategoria;


    public Film(int id, String cim, String kategoria, int hossz, int ertekeles) {
        this.id = id;
        this.cim = cim;
        this.kategoria = kategoria;
        this.hossz = hossz;
        this.ertekeles = ertekeles;
    }

    public int getId() {
        return id;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public int getHossz() {
        return hossz;
    }

    public void setHossz(int hossz) {
        this.hossz = hossz;
    }

    public int getErtekeles() {
        return ertekeles;
    }

    public void setErtekeles(int ertekeles) {
        this.ertekeles = ertekeles;
    }

    public String toJSON() {
        return String.format(
                "{\"cim\":\"%s\",\"kategoria\":\"%s\",\"hossz\":%d,\"ertekeles\":%d}",
                this.cim, this.kategoria, this.hossz, this.ertekeles
        );
    }
}
