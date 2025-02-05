package uke6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParantesSjekkerTest {
    private final ParantesSjekker sjekker = new ParantesSjekker();

    @Test
    void testGyldigParanteser() {
        assertTrue(sjekker.sjekkParanteser("{ ( [ ] ) }"));
    }

    @Test
    void testManglerSluttParantes() {
        assertFalse(sjekker.sjekkParanteser("{ [ ( ) }"));
    }

    @Test
    void testManglerStartParantes() {
        assertFalse(sjekker.sjekkParanteser("[ ( ) ] }"));
    }

    @Test
    void testSluttParantesForTidlig() {
        assertFalse(sjekker.sjekkParanteser("{ [ ( ] ) }"));
    }

    @Test
    void testString() {
        String javaprogram = """
                class HelloWorld {
                    public static void main(String[] args) {
                        System.out.println("Hello World!");
                        }
                    }
                """;

        assertTrue(sjekker.sjekkParanteser(javaprogram));
    }

}
