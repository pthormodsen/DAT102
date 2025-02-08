package no.hvl.data102.filmarkiv.test;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilmarkivTest {


        private FilmarkivADT arkiv;

        Film interstellar = new Film(1, "Produsent1", "Interstellar", 2014, Sjanger.SCIFI, "Warner Bros");
        Film inception = new Film(2, "Produsent2", "Inception", 2010, Sjanger.SCIFI, "Legendary Pictures");
        Film theDarkKnight = new Film(3, "Produsent3", "The Dark Knight", 2008, Sjanger.ACTION, "Warner Bros");
        Film pulpFiction = new Film(4, "Produsent4", "Pulp Fiction", 1994, Sjanger.DRAMA, "Miramax");
        Film theGodfather = new Film(5, "Produsent5", "The Godfather", 1972, Sjanger.DRAMA, "Paramount Pictures");

        @BeforeEach
        public void setUp() {
            arkiv = new Filmarkiv(5);

            arkiv.leggTilFilm(interstellar);
            arkiv.leggTilFilm(inception);
            arkiv.leggTilFilm(theDarkKnight);
            arkiv.leggTilFilm(pulpFiction);
            arkiv.leggTilFilm(theGodfather);

        }

        @Test
        public void testLeggTilFilm() {
            assertEquals(5, arkiv.antall(), "Skal bli 5");
            assertNotNull(arkiv.finnFilm(1), "Interstellar");
            assertNotNull(arkiv.finnFilm(2), "Inception");
            assertNotNull(arkiv.finnFilm(3), "The Dark Knight");
            assertNotNull(arkiv.finnFilm(4), "Pulp Fiction");
            assertNotNull(arkiv.finnFilm(5), "The Godfather");
        }

        @Test
        public void testSlettFilm() {
            boolean slettet = arkiv.slettFilm(5);
            assertTrue(slettet, "Burde bli slettet");
            assertNull(arkiv.finnFilm(5));
            assertEquals(4, arkiv.antall(), "Skal bli 4");
        }

        @Test
        public void testSoekTittel() {
            // Test søk på tittel
            Film[] result = arkiv.soekTittel("Inter");
            assertEquals(1, result.length, "Det bør være én film med 'Inter' i tittelen.");
            assertEquals("Interstellar", result[0].getTittel(), "Tittelen på den første filmen bør være Interstellar.");
        }

        @Test
        public void testUtvidKapacitet() {
            // Legg til flere filmer enn kapasitet
            Film avengersEndgame = new Film(6, "Produsent6", "Avengers: Endgame", 2019, Sjanger.ACTION, "Marvel Studios");
            arkiv.leggTilFilm(avengersEndgame);

            // Test at alle filmer er lagt til
            assertEquals(6, arkiv.antall(), "Antall filmer i arkivet bør være 6 etter utvidelse.");
            assertNotNull(arkiv.finnFilm(6), "Avengers: Endgame bør være i arkivet.");
        }



}
