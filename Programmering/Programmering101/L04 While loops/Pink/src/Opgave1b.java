public class Opgave1b {

    //Opgave b
    // Lav en klasse med en main metode().
    //Programmer i main() metoden en while-løkke, som summerer alle kvadrattal
    //mellem 1 og 100.
    //(Bemærk, at kvadratet skal være <= 100. Resultatet skal være 385.)

    public static void main(String[] args) {



        int result = Opgb();
        System.out.println(result);
    }

    public static int Opgb() {
        int sum =0;
        int i = 1;
        while (i*i < 101) {
            //System.out.println(i +": " + i*i);
            sum=sum+i*i;
            //System.out.println("sum: " + sum);
            i++;
        }
        return sum;
    }
}
