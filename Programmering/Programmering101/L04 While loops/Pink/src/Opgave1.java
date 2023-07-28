public class Opgave1 {

    // Lav en klasse med en main() metode.
    //Programmer i main() metoden en while-løkke, som summerer alle lige tal
    //mellem 2 og 100 (begge inklusive).
    //(Resultatet skal være 2550.)

    public static void main(String[] args) {

        //Start med 2
        // sum = 0
        // While går op til 100
        // sum = gammel sum + "ny" g
        // g + 2 (fordi kun hele tal)
        int g = 2;
        int sum = 0;
        while (g < 100) {

        sum = sum + g;
            g = g + 2;

            System.out.println(sum + g);

        }
    }

}
