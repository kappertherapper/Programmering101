public class whileEKSEMPEL {

    private static boolean whileStopKlods = true;

    public static void main(String[] args) {

        int i = 0;
        while (whileStopKlods) {

            System.out.println("Jeg har stjålet din hundehvalp");
            System.out.println("Du har et crush på kantine damen");

            i = i + 1;
            if (i < 5)
            {
                changeBooleanState();
            }
        }


    }

    private static void changeBooleanState(){
        whileStopKlods = false;

    }



}
