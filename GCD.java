// Code created by Aditya Mehrotra.

import java.util.Scanner;
import javax.tools.Diagnostic;

public class GCD {
    public static void main(String args[]) {
        // Create a Scanner object called scanner
        Scanner scanner = new Scanner(System.in);

        // Get all of the requried information and store in variables
        System.out.print("First Number: ");
        int firstNum = scanner.nextInt();
        System.out.print("Second Number: ");
        int secondNum = scanner.nextInt();
        System.out.println("Which Algorithm will you like to Use: Efficient (1) or Naive (2): ");
        int algorithmChoice = scanner.nextInt();
        System.out.println("");

        // Check which Algorithm the User wants to Use, and Output the Result from said Algorithm
        if (algorithmChoice == 1) {
            System.out.print("The Greatest Common Divisor of " + firstNum + " and " + secondNum + " is: " + gcd_efficient(firstNum, secondNum));
        } else {
            System.out.print("The Greatest Common Divisor of " + firstNum + " and " + secondNum + " is: " + gcd_naive(firstNum, secondNum));
        }
    }
    
    /*
     * Method that calculates the Greatest Common Divisor of two numbers. This method is an implementation of a Naive Algorithm.
     * 
     * @param {int} firstNum - First Number
     * @param {int} secondNum - Second Number
     * @return {int} - Greatest Common Divisor of the First Number and Second Number
     */
    private static int gcd_naive(int firstNum, int secondNum) {
        // Create a new int variable that hold the current GCD
        int currentGCD = 1;

        // Iterate from 2 to min(firstNum, secondNum)
        for(int i = 2; ((i <= firstNum) && (i <= secondNum)); i++) {
            // If the first number and the second number has a remainder of 0 when divided by i, and if i is greater than the Current GCD,
            // then set the Current GCD to i
            if ((firstNum % i == 0) && (secondNum % i == 0)) {
                if (i > currentGCD) {
                    currentGCD = i;
                }
            }
        }

        // Return the Current GCD
        return currentGCD;
    }

    /*
     * Method that calculates the Greatest Common Divisor of two numbers. This method is an implementation of an Efficient Algorithm.
     * 
     * @param {int} firstNum - First Number
     * @param {int} secondNum - Second Number
     * @return {int} - Greatest Common Divisor of the First Number and Second Number
     */
    private static int gcd_efficient(int firstNum, int secondNum) {
        // Check if the second number equals 0, if so, return the first number
        if (secondNum == 0) {
            return firstNum;
        }

        // Create a new variable that stores the remainder of the first number divided by the second number
        int firstNumPrime = firstNum % secondNum;

        // Recursively call the same function with the second number and firstNumPrime, and return the final answer
        return gcd_efficient(secondNum, firstNumPrime);
    }
}
