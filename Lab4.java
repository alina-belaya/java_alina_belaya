import java.util.Scanner;

public class Lab4 {

	public static void main(String[] args) {
		// 3.8
		Scanner in = new Scanner(System.in);
        System.out.print("Input x: ");
        double x = in.nextDouble();
        int a = (int) x;
        float b = (float) (x - a);
        System.out.println("Ціла частина: " + a + ", дробова частина:" + b);
        
        if (a >= 0) {
        	System.out.println("Найменше число, що більше: " + (a+1));
        	System.out.println("Найбільше число, що менше: " + a);
        } else {
        	System.out.println("Найменше число, що більше: " + a);
        	System.out.println("Найбільше число, що менше: " + (a-1));
        }
        
        if ((-b >= 0.5) & (a >= 0)) {
        	a += 1;
        	System.out.println("Округлене: " + a);
        } else if ((-b >= 0.5) & (a < 0)) {
        	a -= 1;
        	System.out.println("Округлене: " + a);
        } else {
        	System.out.println("Округлене: " + a);
        }
        

	}

}
