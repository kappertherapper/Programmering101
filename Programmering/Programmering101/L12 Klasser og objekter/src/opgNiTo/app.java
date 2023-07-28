package opgNiTo;

public class app {
    public static void main(String[] args) {
        stock g = new stock("ORCL", "Oracle");

        g.setCurrentPrice(69);
        g.setPreviousClosingPrice(73);

        System.out.println(g.toString());
        System.out.println();
        System.out.println(g.getChangePercent() + "% forskel");


    }
}
