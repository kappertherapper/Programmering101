package opgNiEt;

public class Rectangle {

    double width = 1;
    double height = 1;
    double area;
    double perimeter;

    public Rectangle(double width, double height) {

        this.width = width;
        this.height = height;

    }

    public void RectangleSpecific(double width, double height) {

        this.width = 69;
        this.height = 69;

    }

    public double getArea() {

        return width * height;

    }

    public double getPerimeter() {

        return 2 * width +  2 * height;

    }

    @Override
    public String toString() {
        return  "\n" + "width = " + width +
                "\n" + "height = " + height +
                "\n" + "area = " + area +
                "\n" + "perimeter = " + perimeter;
    }
}
