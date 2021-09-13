
public class Lab4 {
	
	static void chartobin(char c) {
		System.out.println(Integer.toBinaryString(c));
	}

	public static void main(String[] args) {
		// 2.3
		char c1 = 'c';
		char c2 = 'A';
		char c3 = 'Z';
		chartobin(c1);
		chartobin(c2);
		chartobin(c3);

	}

}
