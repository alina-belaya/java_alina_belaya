package homework;

public class HW11_1 {
    public static void main(String []args) {
        String str1 = "String, with 1 comma.";
        System.out.println("String: " + str1);
        checkCommaPosition(str1);
        countCommas(str1);

        String str2 = "New, string, with 3, commas.";
        System.out.println("String: " + str2);
        checkCommaPosition(str2);
        countCommas(str2);
    }

     static void checkCommaPosition(String str){
        int index_first = str.indexOf(",");
        if (index_first != -1){
            int index_last = str.lastIndexOf(",");
            System.out.println("First comma is at index " + index_first);
            System.out.println("Last comma is at index " + index_last);
        } else {
            System.out.println("There`s no comma on this string");
        }
    }

     static void countCommas(String str){
        int count = 0;
        char temp;
        for (int i = 0; i < str.length(); i++) {
            temp = str.charAt(i);
            if (temp == ',')
                count++;
        }
        System.out.println("Comma count: " + count + "\n");
    }
}
