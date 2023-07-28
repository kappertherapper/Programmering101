public class ellebælletælle {
    public static void main(String[] args) {
        displayPattern(10);
    }


    public static void displayPattern(int n) {
        int row = 1;
        while (row <= n) {
            int col = 1;
            while (col <= n) {
                if (col <= n-row) System.out.print("   ");
                else System.out.printf("%3d", col - (n-row));
                col++;

            }
            System.out.println();
            row++;
        }
    }
}
