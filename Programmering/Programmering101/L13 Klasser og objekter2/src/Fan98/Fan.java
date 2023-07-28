package Fan98;

public class Fan {

    public static final int slow = 1;
    public static final int medium = 2;
    public static final int fast = 3;
    boolean on = false;
    String color;
    double radius;
    public int speed;

    public Fan(String color, boolean on, double radius, int speed) {
        this.color = color;
        this.on = on;
        this.radius = radius;
        this.speed = speed;

    }

    //Choose to turn on or off (off as default)
    private boolean on() {

        return on;
    }

    @Override
    public String toString() {
        String speedstr;
        if (speed == 1) speedstr = "SPEED IS SLOW";
        else if (speed == 2) speedstr = "SPEED IS MEDIUM";
        else if (speed == 3) speedstr = "SPEED IS FAST";
        else speedstr = "error";


        if (on) {
        return "Fan moister 3000" + "\n" +
                "The color of the fan is: " + color + "\n" +
                "The speed of the fan is: " + speedstr + "\n" +
                "The radius of the fan is: " + radius;
        } else {
        return "Fan moister 3000" + "\n" +
                "The color of the fan is: " + color + "\n" +
                "The radius of the fan is: " + radius;

    }


    }




}

