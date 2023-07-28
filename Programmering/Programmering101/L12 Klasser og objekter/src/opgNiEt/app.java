package opgNiEt;

public class app {
    public static void main(String[] args) {
        Rectangle f = new Rectangle(45, 90);

        f.area = f.getArea();
        f.perimeter = f.getPerimeter();

        System.out.println(f.toString());

    }
}
