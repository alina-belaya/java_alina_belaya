import java.util.Scanner;

public class HW2_2 {
	
	public static double y(double x) {
		double res = 1, a = x;
		 
        for (int i = 1; i < 5; i++) {
            res = res + a;
            a = a * x;
        }
 
        return res;
		
	}

	public static void main(String[] args) {
		
		double x;
		Scanner in = new Scanner(System.in);
		
		System.out.print("Input x: ");
		x = in.nextDouble();
		
		System.out.println("Result: " + y(x));

	}

}
