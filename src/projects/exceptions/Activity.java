package projects.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver class
 *
 * @author Wade Huber
 *
 */
public class Activity {

    public static void main(String[] args) {
        Fraction sampleFraction = new Fraction(8,3);
        Scanner scan = new Scanner(System.in);

        // Get Numerator
        sampleFraction.setNumerator(promptValidInput("Enter the numerator: ",scan));

        // Wait until the fraction is created.
        while(true) {

            // Get Denominator
            sampleFraction.setDenominator(promptValidInput("Enter the denominator:  ", scan));

            // Validate that the denominator was not zero.
            try{
                System.out.println("The fraction " + sampleFraction.getNumerator() + "/" +
                        sampleFraction.getDenominator() + " is equal to " + sampleFraction.toMixedNumber());
                break;
            }catch (ArithmeticException e) {
                System.out.println("The fraction was failed to be created due to the division of zero. Remember, fractions cannot have a denominator of zero.");
            }
        }

        scan.close();
    }

    /**
     * Repeatedly scans for a valid integer value.
     *
     * @param prompt a prompt to be given to be printed.
     * @param scanner the scanner used to collect input.
     * @return
     */
    public static int promptValidInput(String prompt, Scanner scanner){
        while(true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("The input you provided threw a Input Mismatch Exception");
                scanner.next();
            }
        }
    }
}