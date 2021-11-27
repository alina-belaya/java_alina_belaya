package homework;

public class HW9_1 {
    public static void main(String[] args){
        int radius = 2;
        int Ox = 2;
        int Oy = 1;
        Point circleCentre = new Point(Ox, Oy);
        Circumference circumference = new Circumference(radius, circleCentre);

        int x = 3;
        int y = 3;
        Point P = new Point(x, y);

        Circle circle = new Circle(circumference);

        printRes(circle, P);

        int newRadius = 5;
        circle.changeR(newRadius);

        printRes(circle, P);

    }

    public static void printRes(Circle circle, Point P){
        if(circle.isInsideCircle(P)) System.out.println("Point " + P + " is in circle " + circle);
        else System.out.println("Point " + P + " is not in circle " + circle);
    }
}
