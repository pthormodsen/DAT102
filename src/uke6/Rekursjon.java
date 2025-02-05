package uke6;

public class Rekursjon {

    public static int utregning(int n){
        if(n == 1){
            return 1;
        } else {
            System.out.println(n);
            return utregning(n-1) + n;
        }
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(utregning(n));
    }
}
