package homework;

import java.util.Arrays;
import java.util.Scanner;

public class HW5_1 {
    public static void main(String[] args) {
        System.out.print("Input n: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int arr_i = 0;
        int[] res = new int[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Input element[%d]: ", i+1);
            Scanner in2 = new Scanner(System.in);
            int element = in2.nextInt();
            arr[i] = element;
            String element_to_str = String.valueOf(element);
            if (element_to_str.length() > 1 & element_to_str.equals((sorting(element_to_str)))) {
                res[arr_i] = element;
                arr_i++;
            }
        }

        System.out.println("Result: ");
        for (int i = 0; i < n; i++) {
            if (res[i] == 0) {
                break;
            }
            System.out.print(res[i] + " ");
        }
    }

    public static String sorting(String number_str) {
        char[] digits = number_str.toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }
}
