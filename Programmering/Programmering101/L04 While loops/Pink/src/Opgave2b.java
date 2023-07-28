import java.util.Scanner;

//Lav en klasse med en main() metode.
//Tilføj til klassen en metode sumEvenInts(int a, int b), der returnerer summen af
//alle lige tal mellem a og b.
//(Resultatet af sumEvenInts(7, 24) er 144.)
//Kald metoden i main() metoden. Grænserne a og b skal indlæses fra
//tastaturet.

public class Opgave2b {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter upper limit ");
        int lowerLimit = input.nextInt();
        System.out.print("Enter lower limit ");
        int upperLimit = input.nextInt();

        int result = opgb(lowerLimit, upperLimit);
        System.out.println("Alle lige tal er: " + result);


    }

    public static int opgb (int a, int b) {

        int sum = 0;
        int tal = a;
        while (tal <= b);
        if (tal % 2 == 0) {
            sum += tal;

        }
        tal++;

        return sum;
    }
}
