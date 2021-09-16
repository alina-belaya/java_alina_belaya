import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class HW2_1 {

	public static void main(String[] args) {
		double a, b;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Input a b: ");
		a = in.nextDouble();
		b = in.nextDouble();
		
		double armean = (a+b)/2;
		double harmean = 2*a*b/(a+b);
		
		NumberFormat formatter1 = new DecimalFormat("#0.000");
		NumberFormat formatter2 = new DecimalFormat("#0.000E0");

		System.out.println("Result (arithmetic decimal) = " + formatter1.format(armean));
		System.out.println("Result (arithmetic scientific) = " + formatter2.format(armean));
		
		System.out.println("Result (harmonic decimal) = " + formatter1.format(harmean));
		System.out.println("Result (harmonic scientific) = " + formatter2.format(harmean));

	}

}
