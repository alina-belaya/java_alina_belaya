import java.text.DecimalFormat;


public class HW4_1 {
	
	private static final String[] tensNames = {
		    "",
		    " ten",
		    " twenty",
		    " thirty",
		    " forty",
		    " fifty",
		    " sixty",
		    " seventy",
		    " eighty",
		    " ninety"
		  };
	
	private static final String[] numNames = {
		    "",
		    " one",
		    " two",
		    " three",
		    " four",
		    " five",
		    " six",
		    " seven",
		    " eight",
		    " nine",
		    " ten",
		    " eleven",
		    " twelve",
		    " thirteen",
		    " fourteen",
		    " fifteen",
		    " sixteen",
		    " seventeen",
		    " eighteen",
		    " nineteen"
		  };
	
	private static String convertHundreds(int number) {
	    String num;

	    if (number % 100 < 20){
	      num = numNames[number % 100];
	      number /= 100;
	    }
	    else {
	      num = numNames[number % 10];
	      number /= 10;

	      num = tensNames[number % 10] + num;
	      number /= 10;
	    }
	    if (number == 0) return num;
	    return numNames[number] + " hundred" + num;
	  }
	
	public static String convert(long number) {
	    if (number == 0) { return "zero"; }
	    String result = "";
	    
	    if (number < 0) {
	    	result += "minus";
	    	number *= -1;
	    }

	    String snumber = Long.toString(number);

	    String zeroes = "000000000";
	    DecimalFormat df = new DecimalFormat(zeroes);
	    snumber = df.format(number);
	    
	    int millions  = Integer.parseInt(snumber.substring(0,3));
	    int hundredThousands = Integer.parseInt(snumber.substring(3,6));
	    int thousands = Integer.parseInt(snumber.substring(6,9));

	    String newMillions;
	    if (millions == 0) {
	    	newMillions = "";
	    } else {
	    	newMillions = convertHundreds(millions) + " million ";
	    }
	    result =  result + newMillions;

	    String newHundredThousands;
	    if (hundredThousands == 0) {
	    	newHundredThousands = "";
	    } else {
	    	newHundredThousands = convertHundreds(hundredThousands) + " thousand ";
	    }
	    result =  result + newHundredThousands;

	    String newThousands;
	    newThousands = convertHundreds(thousands);
	    result = result + newThousands;

	    return result;
	  }

	public static void main(String[] args) {
		System.out.println(HW4_1.convert(0));
	    System.out.println(HW4_1.convert(-16));
	    System.out.println(HW4_1.convert(801));
	    System.out.println(HW4_1.convert(1316));
	    System.out.println(HW4_1.convert(3000200));
	    System.out.println(HW4_1.convert(9001023));
	    System.out.println(HW4_1.convert(123456789));
	    System.out.println(HW4_1.convert(-999999999));

	}

}
