

public class Trangle {
    Point a = new Point(-3, -2);
    Point b = new Point(0, -1);
    Point c = new Point(-2, 5);
    double l1 = length(a,b);
    double l2 = length(a,c);
    double l3 = length(b,c);


    public static double length(Point a, Point b) {//рассчет длины стороны
        return Math.sqrt((a.getX() - b.getX()) * (a.getX() - b.getX()) + (a.getY() - b.getY()) * (a.getY() - b.getY()));
    }

}
