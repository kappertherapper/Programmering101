package opgaver;

public class ex1 {


    /** returns true or false, whether an uneven number exists in an array **/
    public static boolean uneven(Integer[] args) {
        boolean found = false;
        int i = 0;
        while (!found && i < args.length) {
            int k = args[i];
            if (k != 0) {
                found = true;
            } else
                i++;
        }
        return found;
    }


    /** finds the first number belonging to the interval [10;15] **/
    public static int IntervalTiFemten(int[] args) {
        boolean found = false;
        int i = 0;
        int k = -1;
        int min = 10;
        int max = 15;

        while (!found && i < args.length) {
            k = args[i];
            if (k >= min && k <= max) {
                found = true;

            } else
                i++;
        }
        return k;
    }

    /** returns true, if two adjacent numbers are the same,
     * The method takes an array of integer numbers as parameter **/
    public static boolean adjacentNumbers(int[] arr) {
        boolean found = false;
        int i = 0;
        int k;
        int j;

        while (!found && i < arr.length - 1) {
            k = arr[i];
            j = arr[i + 1];
            if (k == j) {
                found = true;
            } else
                i++;

        }
        return found;
    }

    /** returns true, if the same number exists in n adjacent places,
     * The method takes an array of integer numbers as parameter **/
    public static boolean adjacentTimes(int[] arr, int n) {
        int i = 0;
        boolean found = false;

        while (!found && i < arr.length - n + 1) {
            boolean flag = true;

            int j = i + 1;
            while (j < i + n) {
                if (arr[i] != arr[j]) {
                    flag = false;

                }
                j++;

            }
            if (flag) {
                found = true;
            }
            i++;
        }
        return found;
    }
}
