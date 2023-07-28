package name;

public class nameapp {
    public static void main(String[] args) {
        name p1 = new name("Mateusz", "Dziurdz" );
        name p2 = new name("Margrethe", "Mosbæk", "Dybdahl");

        //Person 2
        System.out.println(p2.getFullName());

        //Person 1
        System.out.println(p1.getFullName());


    }
}
