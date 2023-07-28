package model;

import java.util.ArrayList;
import java.util.function.IntFunction;

public class Hotel extends ArrayList<Hotel> {
    private String name;
    private double priceSingleRoom;
    private double priceDoubleroom;
    private final ArrayList<Extra> extras = new ArrayList<>();
    private final ArrayList<Registration> registrations = new ArrayList<>();

    public Hotel(String name, double priceSingleRoom, double priceDoubleroom) {
    this.name = name;
    this.priceSingleRoom = priceSingleRoom;
    this.priceDoubleroom = priceDoubleroom;
    }

    // -------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public double getPriceSingleRoom() {
        return priceSingleRoom;
    }

    public double getPriceDoubleroom() {
        return priceDoubleroom;
    }

    // -------------------------------------------------------------------------

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceSingleRoom(double priceSingleRoom) {
        this.priceSingleRoom = priceSingleRoom;
    }

    public void setPriceDoubleroom(double priceDoubleroom) {
        this.priceDoubleroom = priceDoubleroom;
    }

    @Override
    public String toString() {
        return  name +
                " [Single room = " + priceSingleRoom + " kr " + "] " +
                " [Double room = " + priceDoubleroom + " kr " + "] " + extras;
    }

    // -----------------------------------------------------------------------------
    public void addExtras(Extra extra) {
        extras.add(extra);
    }

    public void removeExtras(Extra extra) {
        extras.remove(extra);
    }

    public ArrayList<Extra> getExtras() {
        return new ArrayList<>(extras);
    }

    // -----------------------------------------------------------------------------

    public ArrayList<Registration> getRegistrations() {
        return new ArrayList<>(registrations);
    }

    public void addRegistration(Registration registration){
        registrations.add(registration);
    }

}
