package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
    private int filmnr;
    private String produsent;
    private String tittel;
    private int lansering;
    private Sjanger sjanger;
    private String filmselskap;
    
    public Film() {}
    
    public Film(int filmnr, String produsent, String tittel, int lansering, Sjanger sjanger, String filmselskap) {
        this.filmnr = filmnr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.lansering = lansering;
        this.sjanger = sjanger;
        this.filmselskap = filmselskap;
    }

    public int getFilmnr() {
        return filmnr;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public String getProdusent() {
        return produsent;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public int getLansering() {
        return lansering;
    }

    public void setLansering(int lansering) {
        this.lansering = lansering;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return filmnr == film.filmnr && lansering == film.lansering && Objects.equals(produsent, film.produsent) && Objects.equals(tittel, film.tittel) && Objects.equals(sjanger, film.sjanger) && Objects.equals(filmselskap, film.filmselskap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmnr, produsent, tittel, lansering, sjanger, filmselskap);
    }
}
