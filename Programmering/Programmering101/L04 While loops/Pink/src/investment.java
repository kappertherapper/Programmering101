import java.util.Scanner;

public class investment {
    public static void main(String[] args) {
        // Create a scanner
        Scanner input = new Scanner(System.in);

        System.out.println("Investment amount: ");
        double amount = input.nextDouble();
        System.out.println("Yearly interest in %: ");
        double yearlyInterestRate = input.nextDouble();

        System.out.println("Year  Future Valur");
        int year = 1;
        while (year <= 30) {
            double futureValue = futureInvestmentValue(amount, yearlyInterestRate / 100 / 12, year);
            System.out.println();
            year++;
        }
    }

    private static double futureInvestmentValue(double amount, double v, int year) {
        return amount;
    }
}
