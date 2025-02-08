package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Tekstgrensesnitt {

    public Film lesFilm(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Filmnummer: ");
        int filmnr = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Produsent: ");
        String produsent = scanner.nextLine();

        System.out.print("Tittel: ");
        String tittel = scanner.nextLine();

        System.out.print("Lansering: ");
        int lansering = scanner.nextInt();
        scanner.nextLine();

        Sjanger sjanger = null;
        boolean gyldigSjanger = false;

        while(!gyldigSjanger){
            System.out.print("Sjanger (1. Action, 2. Drama, 3. Sci-Fi, 4. Komedie, 5. Animasjon, 6. Romantikk, 7. Skrekk): ");
            int sjangerNr = scanner.nextInt();
            scanner.nextLine();

            switch (sjangerNr) {
                case 1:
                    sjanger = Sjanger.ACTION;
                    gyldigSjanger = true;
                    break;
                case 2:
                    sjanger = Sjanger.DRAMA;
                    gyldigSjanger = true;
                    break;
                case 3:
                    sjanger = Sjanger.SCIFI;
                    gyldigSjanger = true;
                    break;
                case 4:
                    sjanger = Sjanger.KOMEDIE;
                    gyldigSjanger = true;
                    break;
                case 5:
                    sjanger = Sjanger.ANIMASJON;
                    gyldigSjanger = true;
                    break;
                case 6:
                    sjanger = Sjanger.ROMANTIKK;
                    gyldigSjanger = true;
                    break;
                case 7:
                    sjanger = Sjanger.SKREKK;
                    gyldigSjanger = true;
                    break;
                default:
                    System.out.println("Ugyldig sjangernummer, setter til null.");
                    break;
            }
        }

        System.out.print("Filmselskap: ");
        String filmselskap = scanner.nextLine();


        return new Film(filmnr, produsent,tittel,lansering,sjanger,filmselskap);
    }

    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
        System.out.print("Filmnummer: " + film.getFilmnr());
        System.out.print("Produsent: " + film.getProdusent());
        System.out.print("Tittel: " + film.getTittel());
        System.out.print("Lansering: " + film.getLansering());
        System.out.print("Sjanger: " + film.getSjanger());
        System.out.print("Filmselskap: " + film.getFilmselskap());
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekTittel(delstreng);
        for (Film film : filmer) {
            skrivUtFilm(film);
        }
    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekProdusent(delstreng);
        for (Film film : filmer) {
            skrivUtFilm(film);
        }
    }

    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
// og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Antall filmer: " + arkiv.antall());
        for(Sjanger sjanger : Sjanger.values()){
            int antallSjanger = arkiv.antall(sjanger);
            System.out.println(sjanger + ": " + antallSjanger );
        }
    }

    public void leggTilForhaandsdefinerteFilmer(FilmarkivADT arkiv) {
        // Legg til noen eksempler på filmer i arkivet med riktig rekkefølge
        arkiv.leggTilFilm(new Film(1, "Wachowski", "The Matrix", 1999, Sjanger.SCIFI, "Warner Bros."));
        arkiv.leggTilFilm(new Film(2, "Nolan", "Inception", 2010, Sjanger.SCIFI, "Warner Bros."));
        arkiv.leggTilFilm(new Film(3, "Coppola", "The Godfather", 1972, Sjanger.DRAMA, "Paramount Pictures"));
    }

// osv ... andre metoder
}
