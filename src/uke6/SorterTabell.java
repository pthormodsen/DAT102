package uke6;

import java.util.ArrayList;

public class SorterTabell {
    public static <T extends Comparable<? super T>> void sorterVedInnsetting(T[] a, int forste, int siste) {
        for(int i = forste + 1; i <= siste; i++) {
            T temp = a[i];
            int fra = i - 1;

            while(fra >= forste && temp.compareTo(a[fra]) < 0){
                a[fra + 1] = a[fra];
                fra--;
            }

            a[fra + 1] = temp;
        }
    }
}
