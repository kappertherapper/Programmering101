package opgaver;

import java.util.ArrayList;

public class opg1 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Hans");
        names.add("Viggo");
        names.add("Jens");
        names.add("Bente");
        names.add("Bent");

        //Prints size of Arraylist
        System.out.println(names.size());

        //Adds to index 2
        names.add(2,"Jane");

        //Print the elements in our Arraylist
        System.out.println(names);

        //Removes index 1
        names.remove(1);

        //Adds at the front of list
        names.add(0,"Pia");

        //Adds at the rear of list
        names.add("Ib");

        //Prints size of Arraylist
        System.out.println(names.size());

        //Replaces element in index 2
        names.add(2,"Hansi");

        //Prints size of Arraylist
        System.out.println(names.size());

        //Print the elements in our Arraylist
        System.out.println(names);

        //Print length of each element (for statement)
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i).length());
        }

        //Print length of each element (for each)
        for (String name : names) {
            System.out.println(name.length());
        }
    }
}
