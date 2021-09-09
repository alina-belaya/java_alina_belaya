import java.util.Scanner;

public class Lab1 {

	public static void main(String[] args) {
		//ціле число в 8 степінь
		Scanner in = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = in.nextInt();
        
        int result = 1;
        
        for(int i=1; i<=8; i++) {
        	result = result * n;
        }
        
        System.out.println("Result: " + result);

	}

}
