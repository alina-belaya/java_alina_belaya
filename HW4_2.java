import java.util.Scanner;

public class HW4_2 {
	
	public static void doubleRoot(double a, double b, double c) {
		double D = b * b - 4 * a * c;
		if (D > 0) {
			double x1, x2;
			x1 = (-b - Math.sqrt(D)) / (2 * a);
			x2 = (-b + Math.sqrt(D)) / (2 * a);
			System.out.format("Roots: x1 = %.2f, x2 = %.2f", x1, x2);
		} else if (D == 0) {
			double x;
			x = -b / (2 * a);
			System.out.format("Only root: x = %.2f", x);
		} else {
			System.out.println("No double roots");
		}
	}
	
	public static void complexRoot(double a, double b, double c) {
		double D = b * b - 4 * a * c;
		if (D > 0) {
			double x1, x2;
			x1 = (-b - Math.sqrt(D)) / (2 * a);
			x2 = (-b + Math.sqrt(D)) / (2 * a);
			System.out.format("Roots: x1 = %.2f+0i, x2 = %.2f+0i", x1, x2);
		} else if (D == 0) {
			double x;
			x = -b / (2 * a);
			System.out.format("Only root: x = %.2f+0i", x);
		} else {
			double r = -b / (2 * a);
			double i = Math.sqrt(-D) / (2 * a);
			System.out.format("x1 = %.2f+%.2fi", r, i);
			System.out.format("\nx2 = %.2f-%.2fi", r, i);
	    }
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("For DOUBLE input 0, COMPLEX - 1: ");
		int choice = in.nextInt();
		
		System.out.print("Input a, b, c: ");
		double a = in.nextDouble();
		double b = in.nextDouble();
		double c = in.nextDouble();
		
		if (choice == 0) {
			HW4_2.doubleRoot(a, b, c);
		} else {
			HW4_2.complexRoot(a, b, c);
		}

	}

}
