package ols2405.searching;

import java.util.Scanner;

public class Games {
    void play(int low, int high) {
        int mid, i = 1;
        char response = 'n';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess a number between " + low + " and " + high + "! then press [y].");
        response = scanner.next().charAt(0);

        if (response == 'y') {

            while (low <= high) {
                mid = (low + high) / 2;
                System.out.printf("Is %d the value ([y] or [n])? ", mid);
                response = scanner.next().charAt(0);
                if (response == 'y') {
                    System.out.printf("I guessed the number in %d attempt(s).\n", i);
                    break;
                } else {
                    System.out.println("Let me try again!");
                    System.out.printf("Is %d too high ([y] or [n])? ", mid);
                    response = scanner.next().charAt(0);
                    if (response == 'y') {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                i++;
            }
            scanner.close();
        }
    }

    public static void main(String[] args) {
        new Games().play(1, 100);
    }
}
