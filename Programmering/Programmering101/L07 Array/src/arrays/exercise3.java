package arrays;

public class exercise3 {
    public static void main(String[] args) {
        int [] a = new int[] {4,6,7,2,3};
        int [] b = new int[] {4,6,8,2,6};

        sumArrays(a,b);
    }






        public static int sumArrays(int[] a, int[] b) {
            int sum = 0;
            for (int i = 0; i < a.length; i++) {
            sum = a[i] + b[i];

                System.out.print(sum + " ");




            }




            return sum;
        }

    }

    //foreach
    // int sum1 = 0
    // for (int e : t) {
    // sum 1 += e