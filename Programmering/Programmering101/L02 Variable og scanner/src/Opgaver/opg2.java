package Opgaver;
/* Make a program, that inputs a loan amount, the annual interest rate
        and the number of years, and calculates the monthly payment and
        the total payment.

        Monthly payment = loan amount * interest rate pr month / denumerator
        where denumerator = 1 - 1 / (1 + interest rate pr month) ^ number of  months).
        Use Math.pow(a, b) to calculate a ^ b (example: 2 ^ 3 = 8)
 */
import java.util.Scanner;
public class opg2 {
    public static void main(String[] args) {
// Algoritm:
        Scanner input = new Scanner(System.in);

        //Obtain for annual interest rate
        System.out.println("What is the annual interest rate?: ");
        double annualInterestRate = input.nextDouble();

        // Obtain monthly interest rate
        double monthlyInterestRate = annualInterestRate / 1200;

        //Ask numbers of years
        System.out.println("How many year loan?: ");
        double years = input.nextDouble();

        //Obtain for loan amount
        System.out.println("What is the loan amount?: ");
        double loanAmount = input.nextDouble();

        // Monthly payment revealed
        double monthlyPayment =
                (loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12)));
        System.out.println("The total monthlypayment is: " + monthlyPayment);


        //Total payment revealed
        System.out.println("The total payment: " + monthlyPayment * years * 12);


    }
}
