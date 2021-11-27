package homework;

public class Circle {
    private Circumference circumference;

    public Circle(Circumference circumference){
        this.circumference = circumference;
    }

    public Circle(int r, int Ox, int Oy, int x, int y){
        this.circumference = new Circumference(r, new Point(Ox, Oy));
    }

    public void setCircumference(Circumference circumference) {
        this.circumference = circumference;
    }

    public Circumference getCircumference() {
        return circumference;
    }

    public void changeR(int newR){
        circumference.setR(newR);
    }

    public boolean isInsideCircle(Point p){
        return (p.x - circumference.getO().x) * (p.x - circumference.getO().x) +
                (p.y - circumference.getO().y) * (p.y - circumference.getO().y) <= circumference.getR() * circumference.getR();
    }

    @Override
    public String toString() {
        return "(" + circumference + ")";
    }
}
