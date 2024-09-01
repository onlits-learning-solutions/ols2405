package ols2405.interviewprep;

import java.util.Scanner;

class Boxing {
    public static void main(String[] args) {
        int a = 12, b = 24, c;
        c = a + b;
        System.out.println("The value of c is " + c);

        Integer i = 12, j = 24, k; // Autoboxing
        k = i + j;
        int result = k; // Unboxing
        System.out.println("The value of k is " + result);

        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner);
    }
}