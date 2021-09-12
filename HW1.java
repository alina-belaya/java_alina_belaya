import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class HW1 {

	public static void main(String[] args) {
		double a, b, res;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Input a b: ");
		a = in.nextDouble();
		b = in.nextDouble();
		
		res = Math.sqrt(a * b);
		
		NumberFormat formatter1 = new DecimalFormat("#0.000");
		NumberFormat formatter2 = new DecimalFormat("#0.000E0");

		System.out.println("������ ����������� (���������) = " + formatter1.format(res));
		System.out.println("������ ����������� (�������) = " + formatter2.format(res));

	}

}
