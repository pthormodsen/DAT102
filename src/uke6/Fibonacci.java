package uke6;

public class Fibonacci {
    public static int fibonacci(int n) {
        if(n==0){
            return 0; //Basissteget
        }
        if(n==1){
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        for(int i=0; i<30; i++){
            System.out.println(fibonacci(i)+" ");
        }
    }
}
