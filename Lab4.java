import java.util.Scanner;

public class Lab4 {

	public static void main(String[] args) {
		// 3.8
		Scanner in = new Scanner(System.in);
        System.out.print("Input x: ");
        double x = in.nextDouble();
        int a = (int) x;
        float b = (float) (x - a);
        System.out.println("ֳ�� �������: " + a + ", ������� �������:" + b);
        
        if (a >= 0) {
        	System.out.println("�������� �����, �� �����: " + (a+1));
        	System.out.println("�������� �����, �� �����: " + a);
        } else {
        	System.out.println("�������� �����, �� �����: " + a);
        	System.out.println("�������� �����, �� �����: " + (a-1));
        }
        
        if ((-b >= 0.5) & (a >= 0)) {
        	a += 1;
        	System.out.println("���������: " + a);
        } else if ((-b >= 0.5) & (a < 0)) {
        	a -= 1;
        	System.out.println("���������: " + a);
        } else {
        	System.out.println("���������: " + a);
        }
        

	}

}
