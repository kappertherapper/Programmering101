package model;

public class Extra {
    private String name;
    private double price;
    private Hotel hotel;


    public Extra (String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  name + " " + price + " kr";
    }
}
