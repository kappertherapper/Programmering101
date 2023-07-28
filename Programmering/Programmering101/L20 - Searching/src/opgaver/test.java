package opgaver;


public class test {
    public static void main(String[] args) {
        int[] t = new int[] {7, 56, 34, 3, 7, 14, 13, 4};
        int[] p = new int [] {7, 9, 13, 13, 9, 7};
        int[] q = new int [] {2, 2, 2, 3, 4, 5};

        System.out.println(ex1.IntervalTiFemten(t));
        System.out.println(ex1.adjacentNumbers(t));
        System.out.println(ex1.adjacentNumbers(p));
        System.out.println(ex1.adjacentTimes(q,4));



    }
}
