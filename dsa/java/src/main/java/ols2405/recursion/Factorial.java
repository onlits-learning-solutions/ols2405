package ols2405.recursion;

public class Factorial {
    public static int factorial(int n) {
        int f = 1;
        for(int i = n; i>=1; i--) {
            f *= i;
        }
        return f;
    }
}
