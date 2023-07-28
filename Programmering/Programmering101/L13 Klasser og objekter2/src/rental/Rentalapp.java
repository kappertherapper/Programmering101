package rental;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class Rentalapp {
    public static void main(String[] args) {
        Rental hus1 = new Rental(1, 14, 69, LocalDate.now().plusMonths(10));
        Rental hus2 = new Rental(2, 28, 80, LocalDate.now().plusMonths(1).minusDays(7));


        //Hus 1
        System.out.println(hus1.toString());
        System.out.println("Day before rental starts " + hus1.getDayBeforeStart());
        System.out.println("Enddate: " + hus1.getEndDate());
        System.out.println("Total price: " + hus1.getTotalPrice() + "\n");

        //Hus 2
        System.out.println(hus2.toString());
        System.out.println("Day before rental starts " + hus2.getDayBeforeStart());
        System.out.println("Enddate: " + hus2.getEndDate());
        System.out.println("Total price: " + hus2.getTotalPrice());


    }
}
