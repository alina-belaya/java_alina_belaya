package homework;

import java.util.ArrayList;
import java.util.List;

public class HW8_1 {
    public static Polynomial polySum(Polynomial p1, Polynomial p2)
    {
        int tempDeg = Math.min(p1.getDeg(), p2.getDeg());
        Polynomial tempP = new Polynomial(tempDeg);
        for(int i = 0; i < tempDeg; i++)
            tempP.setCoeff(i, p1.getCoeff(i) + p2.getCoeff(i));
        return tempP;
    }

    public static void main(String[] args){
        int c = 1;

        List<Polynomial> poly = new ArrayList<>();

        poly.add(new Polynomial(5, -2, 0, 2, 1, 3));
        poly.add(new Polynomial(2, 7, 0, 3, 0, 2));

        for (Polynomial p: poly){
            System.out.printf("Polynomial %d: %s\n", c, p);
            c++;
        }

        for (int i=0; i<poly.size()-1; i++){
            System.out.println("Sum = " + polySum(poly.get(i), poly.get(i + 1)));
        }
    }
}
