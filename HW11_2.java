package homework;

public class HW11_2 {
    public static void main(String []args) {
        String str1 = "Madam miss XI CMXC IVIL @gmail.com";
        System.out.println("String: " + str1);
        count(str1);

        String str2 = "Eye radar next level VVS email_example@knu.com";
        System.out.println("\nString: " + str2);
        count(str2);
    }

     static boolean isSymmetric(String s){
        String str = s.replaceAll("\\s+", "").toLowerCase();
        int i = 0;
        int reverse = str.length() - 1;
        while (reverse > i) {
            char forwardChar = str.charAt(i++);
            char backwardChar = str.charAt(reverse--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }

    static boolean isRoman(String s){
        return s.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");
    }

    static boolean isEmail(String s){
        return s.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    static void count(String s)
    {
        String str = s + " ";

        String word = "";
        int countSym = 0;
        int countRom = 0;
        int countEmail = 0;
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch != ' ')
                word = word + ch;
            else {
                if (isSymmetric(word))
                    countSym++;
                if (isRoman(word))
                    countRom++;
                if (isEmail(word))
                    countEmail++;
                word = "";
            }
        }
        System.out.println("Count symmetric words: " + countSym);
        System.out.println("Count roman numbers: " + countRom);
        System.out.println("Count email address: " + countEmail);
    }
}
