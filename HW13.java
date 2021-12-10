package homework;

import java.io.*;
import java.util.Scanner;

public class HW13 {
    public static void main(String[] args) {
        int[] elements = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Scanner sc_n = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = sc_n.nextInt();

        writeFile("F.integer", elements);
        int[] f_elements = readFile("F.integer");
        assert f_elements != null;

        int[] g_elements = elementsToG(f_elements, n);
        writeFile("G.integer", g_elements);
    }

    public static int[] elementsToG(int[] elements, int n) {
        int new_m;
        int m = elements.length;

        if (m%n == 0){
            new_m = m / n;
        } else {
            new_m = m / n + 1;
        }
        int[] new_elements = new int[new_m];

        int cur_max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            if (cur_max < elements[i]) {
                cur_max = elements[i];
            }
            if ((i + 1) % n == 0) {
                new_elements[i / n] = cur_max;
                cur_max = Integer.MIN_VALUE;
            } else if ((i + 1) / n == m / n && i == m - 1) {
                new_elements[m / n] = cur_max;
            }
        }
        return new_elements;
    }

    public static void writeFile(String filename, int[] array) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);

            for (int el: array)
                dos.writeInt(el);
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] readFile(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);

            File file = new File(filename);
            long size = file.length();
            int n = (int) size / Integer.BYTES;
            int[] array = new int[n];
            for (int i = 0; i < n; i++)
                array[i] = dis.readInt();
            dis.close();
            return array;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
