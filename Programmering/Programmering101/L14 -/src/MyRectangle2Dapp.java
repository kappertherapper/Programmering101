public class MyRectangle2Dapp {
    public static void main(String[] args) {
        MyRectangle2D h = new MyRectangle2D();
        MyRectangle2D q = new MyRectangle2D(123,123,100,200);

        System.out.println(h.getX());
        System.out.println(h.getY());
        System.out.println(h.getHeight());
        System.out.println(h.getWidth());

        System.out.println();

        System.out.println(q.getX());
        System.out.println(q.getY());
        System.out.println(q.getHeight());
        System.out.println(q.getWidth());
        System.out.println(q.getArea());
        System.out.println(q.getPerimeter());
        System.out.println(q.contains(q.getX(), q.getY()));
    }
}
