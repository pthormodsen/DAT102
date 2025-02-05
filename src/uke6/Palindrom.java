package uke6;

import java.util.Stack;

public class Palindrom {

    public static boolean erPalindrom(String s) {

        if(s.isEmpty() || s.length() == 1){
            return true;
        }

        if(s.charAt(0) == s.charAt(s.length()-1)){
            return erPalindrom(s.substring(1, s.length()-1));
        }

        return false;

    }


    public static void main(String[] args) {
        System.out.println(erPalindrom("abba")); // true
        System.out.println(erPalindrom("regninger")); // true
        System.out.println(erPalindrom("hello")); // false
        System.out.println(erPalindrom("Aba")); // true (ignorerer case)
    }
}
