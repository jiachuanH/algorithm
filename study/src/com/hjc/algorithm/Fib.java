package com.hjc.algorithm;

public class Fib {
    public static void main(String[] args) {

        System.out.println(Fib.fib(9));

    }

    public static int fib(int N) {
        if (N == 1 || N == 2)
            return 1;
        return fib(N - 1) + fib(N - 2);
    }

}
