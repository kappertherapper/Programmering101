public class MyRectangle2D {

    double x = 0;
    double y = 0;
    double height = 1;
    double width = 1;

    public MyRectangle2D() {

    }

    public MyRectangle2D(double x, double y, double height, double width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;

    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea(){

        return width * height;
    }

    public double getPerimeter(){

        return 2 * (width + height);
    }

    public boolean contains(double x, double y) {
        if ((x > this.x-getWidth() && x < this.x) && (y > this.y && y < this.y+getHeight())) {
            return true;

        } else {
            return false;

        }

    }








}
