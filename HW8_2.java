package homework;

import java.util.ArrayList;
import java.util.List;

public class HW8_2 {
    public static Polynomial_ polySum(Polynomial_ p1, Polynomial_ p2)
    {
        int tempDeg = Math.min(p1.getDeg(), p2.getDeg());
        Polynomial_ tempP = new Polynomial_(tempDeg);
        for(int i = 0; i < tempDeg; i++)
            tempP.setCoeff(i, p1.getCoeff(i).add(p2.getCoeff(i)));
        return tempP;
    }

    public static void main(String[] args){
        int c = 1;

        List<Polynomial_> poly = new ArrayList<>();

        poly.add(new Polynomial_(new ComplexNum(1, -2), new ComplexNum(7, 1), new ComplexNum(8, 5)));
        poly.add(new Polynomial_(new ComplexNum(0, 0), new ComplexNum(3, -7),new ComplexNum(2, -6)));

        for (Polynomial_ p: poly){
            System.out.printf("Polynomial %d: %s\n", c, p);
            c++;
        }

        for (int i=0; i<poly.size()-1; i++){
            System.out.println("Sum = " + polySum(poly.get(i), poly.get(i + 1)));
        }
    }
}
