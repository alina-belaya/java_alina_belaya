
public class Lab3 {

	public static void main(String[] args) {
		// 2.2
		int a = 0b11010 << 1;
		int res;
		
		do {
			res = a >>> 1;
			a = res;
			System.out.println(Integer.toBinaryString(res));
		} while (a != 0);

	}

}
