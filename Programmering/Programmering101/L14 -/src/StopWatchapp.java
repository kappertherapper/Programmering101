import java.time.Year;
import java.util.Scanner;

public class StopWatchapp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StopWatch run = new StopWatch();

        System.out.println("Write GO, when u start running:");
        input.nextLine();
        run.start();
        System.out.println(run.getStartTime());

        System.out.println("Write STOP, when u finished");
        input.nextLine();
        run.stop();
        System.out.println(run.getEndTime());

        System.out.println("\n" + "It took you: (in secounds) ");
        System.out.println(run.elapsedTime());

    }
}
