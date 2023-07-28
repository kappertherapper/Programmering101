import java.time.LocalDate;

public class account {

    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;

    private LocalDate dateCreated;

    //public account() {
    //}

    public account(int id, double balance){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = 0;
        this.dateCreated = LocalDate.now();


    }

    //Get id
    public int getId() {
        return id;
    }

    //Set id
    public void setId(int id) {
        this.id = id;
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

    public LocalDate getDateCreated() {

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
