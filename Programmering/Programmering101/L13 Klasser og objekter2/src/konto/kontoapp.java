package konto;

public class kontoapp {
    public static void main(String[] args) {
        konto kurt = new konto("privat", 1, 500, "åben");
        konto man = new konto("privat", 2, 260, "lukket");

        //kurt.indsætBeløb(400);
        //System.out.println(kurt);

        //kurt.hævBeløb(400);
        //System.out.println(kurt);

        man.indsætBeløb(300);
        System.out.println(man);

        kurt.lukKonto();
        System.out.println(kurt);
        kurt.indsætBeløb(1239087234);
    }
}
