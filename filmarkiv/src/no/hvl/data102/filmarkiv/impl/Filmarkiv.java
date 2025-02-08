package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

    private Film[] filmArray;
    private int antall;

    public Filmarkiv(int kapasitet) {
        filmArray = new Film[kapasitet];
        antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        for(int i = 0; i < antall; i++){
            if(filmArray[i].getFilmnr() == nr){
                return filmArray[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if(antall == filmArray.length){
            utvid();
        }
        filmArray[antall++] = nyFilm;
    }

    private void utvid() {
        Film[] nyTabell = new Film[filmArray.length * 2];
        System.arraycopy(filmArray, 0, nyTabell, 0, filmArray.length);
        filmArray = nyTabell;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for(int i = 0; i < antall; i++){
            if(filmArray[i].getFilmnr() == filmnr){
                filmArray[i] = filmArray[antall - 1];
                filmArray[antall - 1] = null;
                antall--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] treff = new Film[antall];
        int teller = 0;
        for (int i = 0; i < antall; i++) {
            if (filmArray[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                treff[teller++] = filmArray[i];
            }
        }
        return trimTabell(treff, teller);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] treff = new Film[antall];
        int teller = 0;
        for (int i = 0; i < antall; i++) {
            if (filmArray[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
                treff[teller++] = filmArray[i];
            }
        }
        return trimTabell(treff, teller);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int teller = 0;
        for (int i = 0; i < antall; i++) {
            if (filmArray[i].getSjanger() == sjanger) {
                teller++;
            }
        }
        return teller;
    }

    @Override
    public int antall() {
        return antall;
    }

    private Film[] trimTabell(Film[] tabell, int lengde) {
        Film[] nyTabell = new Film[lengde];
        System.arraycopy(tabell, 0, nyTabell, 0, lengde);
        return nyTabell;
    }
}
