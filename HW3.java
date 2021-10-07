import java.util.Scanner;

public class HW3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Input numb, bit numb and bit: ");
        
        int number = in.nextInt();
        int bit_number = in.nextInt();
        int bit = in.nextInt();
        
        number = (number & ~(1 << (bit_number - 1))) | ((bit << (bit_number - 1)) & (1 << (bit_number - 1)));
        System.out.println("Result: " + number + " " + Integer.toHexString(number) + " " + Integer.toBinaryString(number));

	}

}
