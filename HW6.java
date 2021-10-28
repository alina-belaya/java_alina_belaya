package homework;

import java.util.Random;
import java.util.Scanner;

public class HW6 {

    static int matrixDeterminant(int[][] matrix, int n) {
        int[][] temp;
        int result = 0;

        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            result = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
            return result;
        }

        for (int i = 0; i < n; i++) {
            temp = new int[n - 1][n - 1];

            for (int j = 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k < i) {
                        temp[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        temp[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }

            result += matrix[0][i] * Math.pow (-1, (double) i) * matrixDeterminant(temp, temp.length);
        }
        return result;
    }

    static int[][] createRandomMatrix(int n){
        int max = n, min = -n;
        Random random = new Random();
        int[][] randomMatr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                randomMatr[i][j] = random.nextInt(max - min) + min;
                System.out.print(randomMatr[i][j]+"\t");
            }
            System.out.print("\n");
        }
        return randomMatr;
    }

    static int[][] createConsoleMatrix(int n){
        int[][] consoleMatr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("Input element[%d][%d]: ", i + 1, j + 1);
                Scanner in2 = new Scanner(System.in);
                int element = in2.nextInt();
                consoleMatr[i][j] = element;
            }
        }
        return consoleMatr;
    }

    public static void main(String[] args) {
        System.out.print("Input n: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[][] matrix = createRandomMatrix(n);
        // int[][] matrix = createConsoleMatrix(n);

        System.out.println("Determinant of the matrix is: " + matrixDeterminant(matrix, n));

    }
}
