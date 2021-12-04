package homework;

public class Circumference {
    private int r;
    private Point O;

    public Circumference(int r, Point O) throws HW10 {
        if (r < 0){
            throw new HW10("Radius cannot be lower than 0");
        }
        this.r = r;
        this.O = O;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) throws HW10 {
        if (r < 0){
            throw new HW10("Radius cannot be less than 0");
        }
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
