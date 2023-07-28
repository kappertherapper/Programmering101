package arrays;

public class exercise2 {
    public static void main(String[] args) {
        int[] t = new int[] {4,6,7,2,3};


        sum(t);

    }


    public static int sum(int[] t) {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += t[i];
        }

        System.out.println("Sum is: " + sum);






        return sum;

        }
    }

