import java.util.Scanner;

public class PAC1Ex1 {

    public static double calculatePiLeibniz(int n) {
        double pi = 0.0;
        int sign = 1;

        for (int i = 0; i < n; i++) {
            pi += sign * (1.0 / (2.0 * i + 1));
            sign *= -1;
        }

        return pi * 4;
    }

    public static void printPiComparison(int n) {
        double pi = calculatePiLeibniz(n);
        double actualPi = Math.PI;

        System.out.println("\nComparison between the calculated value of Pi and the actual value of Pi:");
        System.out.println(pi + " (using Leibniz formula)");
        System.out.println(actualPi + " (actual value of Pi)");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = -1;  // INIT WITH A CORRECT VARIABLE

        System.out.print("Enter the value of N (positive integer number): ");

        // CHECK FOR POSSITIVE NATURAL
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a positive integer.");
            scanner.next(); // FLUSH INCORRECT ENTRY
        }

        n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("The value of N must be a positive integer number.");
        } else {
            printPiComparison(n);
        }

        scanner.close();
    }
}
