package model;

public class Participant {
    String Name;
    String Adress;
    String Phone;

    public Participant (String Name, String Adress, String Phone){
        this.Name = Name;
        this.Adress = Adress;
        this.Phone = Phone;

    }

    public String getName() {
        return Name;
    }

    public String getAdress() {
        return Adress;
    }

    public String getPhone() {
        return Phone;
    }

    @Override
    public String toString() {
        return "Name: " + Name;
    }
}
