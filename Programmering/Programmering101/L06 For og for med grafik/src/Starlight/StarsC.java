package Starlight;

public class StarsC {
    public static void main(String[] args) {
        exA(10);
    }

    public static void exA(int rowCount) {
        for (int row = rowCount; row >= 1; row--) {
            // print row number
            System.out.printf("%2d: ", 11-row);

            // print stars
            int starCount = rowCount - row;
            for (int i = 1; i <= starCount; i++) {
                System.out.print("-");
            }

            // print dashes
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
