package uke6;

import static uke6.Fibonacci.fibonacci;

public class FibonacciV2 {

    public static int fibonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }


    public static void main(String[] args) {
        for (int i = 0; i <= 50; i++) {
            System.out.println("F(" + i + ") = " + fibonacci(i));
        }
    }
}
