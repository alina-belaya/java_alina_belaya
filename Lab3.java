import java.util.Scanner;

public class Lab3 {

	public static void main(String[] args) {
		// 3.7
		double m1, m2, r;
		
        Scanner in = new Scanner(System.in);
        System.out.print("Enter m1: ");
        m1 = in.nextDouble();
        
        System.out.print("Enter m2: ");
        m2 = in.nextDouble();
        
        System.out.print("Enter r: ");
        r = in.nextDouble();
        
        double F = 6.673E-11 * ((m1*m2) / (r*r));
        
        System.out.println("F = " + F);

	}

}
