package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

import java.util.ArrayList;

public class Filmarkiv2 implements FilmarkivADT {

    private int antall;
    private LinearNode<Film> start; //Startnode,

    public Filmarkiv2() {
        this.antall = 0;
        this.start = null;
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> aktuell = start;
        while (aktuell != null) {
            if(aktuell.data.getFilmnr() == nr) {
                return aktuell.data;
            }
            aktuell = aktuell.neste;
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
        nyNode.neste = start;
        start = nyNode;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        if (start == null) {
            return false;
        }

        LinearNode<Film> aktuell = start;
        LinearNode<Film> forrige = null;

        while (aktuell != null) {
            if (aktuell.data.getFilmnr() == filmnr) {
                if(forrige == null) {
                    start = aktuell.neste;
                }
                else {
                   forrige.neste = aktuell.neste;
                }
                antall--;
                return true;
            }
            forrige = aktuell;
            aktuell = aktuell.neste;
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        LinearNode<Film> aktuell = start;
        ArrayList<Film> filmList = new ArrayList<>();

        while (aktuell != null) {
            if(aktuell.data.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                filmList.add(aktuell.data);
            }
            aktuell = aktuell.neste;
        }

        return filmList.toArray(new Film[0]);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        LinearNode<Film> aktuell = start;
        ArrayList<Film> filmList = new ArrayList<>();

        while (aktuell != null) {
            if(aktuell.data.getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
                filmList.add(aktuell.data);
            }
            aktuell = aktuell.neste;
        }

        return filmList.toArray(new Film[0]);
    }

    @Override
    public int antall(Sjanger sjanger) {
        LinearNode<Film> aktuell = start;
        int teller = 0;
        while (aktuell != null) {
            if(aktuell.data.getSjanger() == sjanger) {
                teller++;
            }
            aktuell = aktuell.neste;
        }
        return teller;
    }

    @Override
    public int antall() {
        return antall;
    }
}
