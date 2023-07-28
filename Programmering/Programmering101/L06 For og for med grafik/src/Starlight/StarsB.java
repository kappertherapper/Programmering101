package Starlight;

public class StarsB {
    public static void main(String[] args) {
        exA(10);
    }

    public static void exA(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {
            // print row number
            System.out.printf("%2d: ", row);

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
