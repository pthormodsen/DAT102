package uke6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromTest {
    @Test
    public void testPalindrom() {
        assertTrue(Palindrom.erPalindrom("abba"));
        assertTrue(Palindrom.erPalindrom("regninger"));
        assertTrue(Palindrom.erPalindrom("a"));
        assertTrue(Palindrom.erPalindrom(""));

    }

    @Test
    public void testIkkePalindrom() {
        assertFalse(Palindrom.erPalindrom("patrik"));
        assertFalse(Palindrom.erPalindrom("kake"));
        assertFalse(Palindrom.erPalindrom("mat"));
    }
}
