import java.util.Date;
import java.util.Scanner;

public class ATM {
    Scanner input = new Scanner(System.in);

    public class account {

        private double balance = 0;
        private double annualInterestRate = 0;

        private Date dateCreated;

        public void account() {

            int id = input.nextInt();
            input.nextInt();
            while (id < 0 || id > 9) {
                System.out.println("Enter correct id");
                id = input.nextInt();
                input.nextLine();
            }
            System.out.println();
        }


        //Get balance
        public double getBalance() {
            return balance;
        }

        //Set balance
        public void setBalance(double balance) {
            this.balance = balance;
        }

        //Get annual Interest Rate
        public double getAnnualInterestRate() {
            return annualInterestRate;
        }

        //Set annual Interest Rate
        public void setAnnualInterestRate(double annualInterestRate) {
            this.annualInterestRate = annualInterestRate;
        }

        //Set date created
        public void setDateCreated(Date dateCreated) {
            this.dateCreated = dateCreated;
        }

        public Date getDateCreated() {
            return dateCreated;
        }

        public double getMonthlyInterestRate() {

            return (annualInterestRate / 12);
        }

        public double getMonthlyInterest() {

            return this.balance * getMonthlyInterestRate();
        }

        //Withdraw
        public double withdraw(double amount) {
            this.balance -= amount;

            return amount;
        }

        //Deposit
        public double deposit(double amount) {
            this.balance += amount;

            return amount;

        }
    }
}
