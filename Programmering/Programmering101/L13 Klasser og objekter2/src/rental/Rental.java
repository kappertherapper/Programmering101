package rental;

import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;
import java.time.Period;

public class Rental {

    int number;
    double price;
    Period days;
    LocalDate startDate;

    public Rental(int number, int days, double price, LocalDate startDate) {
        this.number = number;
        this.days = Period.ofDays(days);
        this.price = price;
        this.startDate = startDate;
    }

    //Gets price pr day
    public double getPrice() {
        return price;
    }

    //Set days for period
    public void setDays(Period days) {
        this.days = days;
    }

    //Gets days for period
    public Period getDays() {
        return days;
    }

    //Gets start date
    public LocalDate getStartDate() {
        return startDate;
    }

    //Gets end date
    public LocalDate getEndDate() {
        LocalDate endDate = startDate.plusDays(days.getDays());

        return endDate;
    }

    public LocalDate getDayBeforeStart(){
        LocalDate DayBeforeStart = startDate.minusDays(1);

        return DayBeforeStart;
    }


    //Gets total price
    public double getTotalPrice() {
        return price * days.getDays();
    }

    @Override
    public String toString() {
        return "Rental " +
                "Number = " + number + "\n" +
                "Price = " + price + "\n" +
                "Days = " + days + "\n" +
                "StartDate = " + startDate + "\n";
    }

}
