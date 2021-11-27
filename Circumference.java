package homework;

public class Circumference {
    private int r;
    private Point O;

    public Circumference(int r, Point O){
        this.r = r;
        this.O = O;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public Point getO() {
        return O;
    }

    public void setO(Point o) {
        O = o;
    }

    @Override
    public String toString() {
        return "Radius = " + r + ", Center = " + O;
    }
}
