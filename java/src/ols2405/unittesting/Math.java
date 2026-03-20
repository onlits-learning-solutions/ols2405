package ols2405.unittesting;

public class Math {
    public static int add(int a, int b) {
        return a + b;
    }

    public static int factorial(int n) {
        if(n < 0)
            return -1;  // To to replaced by exception handling
        else if(n == 0 || n == 1)
            return 1;

        return n * factorial(n-1);
    }
}