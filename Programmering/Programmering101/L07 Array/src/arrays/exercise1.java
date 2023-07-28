package arrays;

import java.util.Arrays;

public class exercise1 {
    public static void main(String[] args) {
        // Opgave 1a
        int[] a = new int[10];

        System.out.println("a: " + Arrays.toString(a));


        // Opgave 1b
        int[] b = new int[10];
        int[] bValues = {2, 44, -23, 99, 8, -5, 7, 10, 20, 30};

        System.out.println("b: " + Arrays.toString(bValues));


        // Opgave 1c
        int[] c = new int[10];
        for (int i = 0; i < 10; i++)
            c[i] = i + 1;


        System.out.println("c: " + Arrays.toString(c));


        // Opgave 1d
        int[] d = new int[10];
        for (int i = 0; i < 10; i++)
            d[i] = i * 2 + 2;

        System.out.println("d: " + Arrays.toString(d));


        // Opgave 1e
        int[] e = new int[10];
        for (int i = 0; i < 10; i++)
            e[i] = (int) Math.pow(i + 1, 2);

        System.out.println("e: " + Arrays.toString(e));


        // Opgave 1f
        int[] f = new int[10];
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) {
                sum = 1;
            } else {
                sum = 0;


            }
            f[i] = sum;



        }
        System.out.println("f: " + Arrays.toString(f));


        // Opgave 1g
        int[] g = new int[10];                          
        for (int i = 0; i < 10; i++)
            g[i] = i % 5;

        System.out.println("g: " + Arrays.toString(g));


        // Opgave 1h
        int[] h = new int[10];
        int sumh = 0;
        for (int i = 0; i < 10; i++)
            if (i % 2 == 0) {

                h[i] = i * 2;

                } else {

                h[i] = 2 * i + 1;

            }

        System.out.println("h: " + Arrays.toString(h));
    }

}

