import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class accountapp {
    public static void main(String[] args) {
        account et = new account(1, 50);

        //et.setDateCreated(Date.from(LocalDate.of(2023, Month.JANUARY, 16).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        System.out.println("ID Account: " + et.getId());
        System.out.println("Balance: " + et.getBalance());
        System.out.println("Date for creation of account: " + et.getDateCreated());

        et.withdraw(50);
        System.out.println("\n" + "You took 30 out, and you balance is now: " + et.getBalance());

        et.deposit(500);
        System.out.println("\n" + "You deposited 88, and your balance is now: " + et.getBalance());

        et.setAnnualInterestRate(5);
        System.out.println("\n" + "Your annual interest rate is: " + et.getAnnualInterestRate() + "%");
        System.out.println("Your monthly interest rate is: " + et.getMonthlyInterestRate() + "%");
        System.out.println("Your monthly interest is: " + et.getMonthlyInterest());





        //et.setBalance(699);
        //System.out.println(et.getBalance());
    }
}
