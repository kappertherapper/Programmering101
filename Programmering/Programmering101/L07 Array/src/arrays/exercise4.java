package arrays;

public class exercise4 {
    public static void main(String[] args) {
        int[] t = new int[]{4, 6, 7, 2, 3};


        hasUneven(t);

    }

    public static boolean hasUneven(int[] t) {
        boolean Uneven = true;

        for (int i = 0; i < t.length; i++) {
            if (t[i] % 2 == 0) {
                Uneven = false;
            } else {
                Uneven = true;


            }


        }
        System.out.println(Uneven);
        return Uneven;
    }
}
