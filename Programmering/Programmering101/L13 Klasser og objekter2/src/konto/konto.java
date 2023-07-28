package konto;

public class konto {

    int nummer;
    int saldo;
    String kontoType;
    String status;

    public konto(String kontoType, int nummer, int saldo, String status) {

        this.nummer = nummer;
        this.kontoType = kontoType;
        this.saldo = saldo;
        this.status = status;

    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void indsætBeløb(int beløb) {
        if (this.status.equals("åben")) {
            this.saldo += beløb;
            System.out.println("Du har nu indsat: " + beløb + "\n" + "Og din konto ser nu således ud: " + "\n");
        } else {
            System.out.println("Din konto er lukket og der kan ikke indsættes noget beløb" + "\n");
        }
    }

    public void hævBeløb(int beløb){
        if (this.status.equals("åben")) {
            this.saldo -= beløb;
            System.out.println("Du har nu hævet: " + beløb + "\n" + "Og din konto ser nu således ud: " + "\n");
        } else {
            System.out.println("Din konto er lukket og der kan ikke hæves noget beløb" + "\n");
        }
    }

    public void lukKonto(){

        this.status = "lukket";
    }

    @Override
    public String toString() {
        return "Konto nummer: " + nummer + "\n" +
                "Saldo = " + saldo + "\n" +
                "KontoType = " + kontoType + "\n" +
                "Status = " + status + "\n";
    }
}
