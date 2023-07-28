package datamatiker;

public class datamatiker {
    public static void main(String[] args) {
        String ord1 = "Datamatiker";
        String ord2 = "Uddannelsen";
        String ord3 = ord1.concat(ord2);

        //Store bogstaver
        System.out.println(ord1.toUpperCase());
        System.out.println();

        //Små bogstaver
        System.out.println(ord2.toLowerCase());
        System.out.println();

        //Mellemrum mellem ord
        System.out.println(String.format("%s %s", ord1, ord2));
        System.out.println();

        //Sammensat ord, hvor ord2 er med små bogstaver
        System.out.println(ord1.concat(ord2.toLowerCase()));

        //Længden på ord sammensat
        System.out.println(ord3.length());
        System.out.println();

        //Print 7 første bogstaver i ord1
        System.out.println(ord1.substring(0,7));
        System.out.println();

        //Print 3-7 bogstaver i ord2
        System.out.println(ord2.substring(3,7));
        System.out.println();

        //Print resten i ord3
        System.out.println(ord3.substring(7, 22));

    }
}
