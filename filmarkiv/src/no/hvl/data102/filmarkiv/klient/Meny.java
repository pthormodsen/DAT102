package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;

import java.util.Scanner;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start(){
    tekstgr.leggTilForhaandsdefinerteFilmer(filmarkiv);
    
    Scanner scanner = new Scanner(System.in);
    boolean fortsette =  true;
    while(fortsette){
        visMeny();

        System.out.print("Velg alternativ: ");
        int valg = scanner.nextInt();
        scanner.nextLine();

        switch(valg){
            case 1:
                Film nyFilm = tekstgr.lesFilm();
                filmarkiv.leggTilFilm(nyFilm);
                System.out.println("Filmen ble lagt til");
                break;
            case 2:
                System.out.println("Oppgi filmnummer: ");
                int filmnr = scanner.nextInt();
                scanner.nextLine();
                if(filmarkiv.slettFilm(filmnr)){
                    System.out.println("Film slettet");
                } else  {
                    System.out.println("Film ikke funnet");
                }
                break;
            case 3:
                System.out.println("Oppgi delstreng i tittel: ");
                String tittel = scanner.nextLine();

                //tekstgr.skrivUtFilmDelstrengITittel(tittel);
                break;
        }
    }
    
    }

    private void visMeny() {
        System.out.println("\n--- Meny ---");
        System.out.println("1. Legg til en film");
        System.out.println("2. Slett en film");
        System.out.println("3. Søk etter film med delstreng i tittel");
        System.out.println("4. Søk etter film med delstreng i produsent");
        System.out.println("5. Vis statistikk (antall filmer og sjangerfordeling)");
        System.out.println("6. Avslutt");

    }
}