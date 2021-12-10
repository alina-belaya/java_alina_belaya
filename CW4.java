package classwork;

import java.util.Random;
import java.util.Scanner;

public class CW4 {
    public static void main(String[] args) {
        task3_2();
        task3_3();
        task3_4();
        task3_5();
        System.out.println(task4_20a());
    }

    public static void task3_2() {
        System.out.println("\n=======task 3.2=======");
        Random random = new Random();
        int n = random.nextInt(50) + 10;
        for (int i = 0; i < 25; i++) {
            int t = random.nextInt() % 50;
            System.out.println("Number 1: " + n);
            System.out.println("Number 2: " + t);
            if (t > n){
                System.out.println("Number 2 is bigger");
            } else if (t < n) {
                System.out.println("Number 1 is smaller");
            } else {
                System.out.println("They are equal");
            }
            n = t;
        }
    }

    public static void task3_3() {
        System.out.println("\n=======task 3.3=======");
        Random random = new Random();
        int n = random.nextInt(6) + 1;
        System.out.println("Roll dice: " + n);
    }

    public static void task3_4() {
        System.out.println("\n=======task 3.4=======");
        int a, b, c;
        Scanner in = new Scanner(System.in);
        System.out.print("a: ");
        a = in.nextInt();
        System.out.print("b: ");
        b = in.nextInt();
        System.out.print("c: ");
        c = in.nextInt();
        if (a == b && b == c) {
            System.out.println("Number amount: 1");
        } else {
            if (a == b || b == c || c == a) {
                System.out.println("Number amount: 2");
            } else {
                System.out.println("Number amount: 3");
            }
        }
    }

    public static void task3_5() {
        System.out.println("\n=======task 3.5=======");
        int a, b, c, d, e, res;
        Scanner in = new Scanner(System.in);
        System.out.print("a: ");
        a = in.nextInt();
        System.out.print("b: ");
        b = in.nextInt();
        System.out.print("c: ");
        c = in.nextInt();
        System.out.print("d: ");
        d = in.nextInt();
        System.out.print("e: ");
        e = in.nextInt();
        if (b < a) {
            res = a;
            a = b;
            b = res;
        }
        if (d < c) {
            res = c;
            c = d;
            d = res;
        }
        if (c < a) {
            res = b;
            b = d;
            d = res;
            c = a;
        }
        a = e;
        if (b < a) {
            res = a;
            a = b;
            b = res;
        }
        if (a < c) {
            res = b;
            d = res;
            a = c;
        }
        System.out.println("Median = " + Math.min(d, a));
    }

    public static double task4_20a() {
        System.out.println("\n=======task 4.20a=======");
        int i = 1, j = 1;
        long k = 1;
        double res = 0, eps;
        Scanner in = new Scanner(System.in);
        System.out.print("x = ");
        double x = in.nextDouble();
        while (true) {
            eps = (Math.pow(x, i) * j) / k;
            if (Math.abs(eps) > 0.0001) {
                res += eps;
                j *= -1;
                k *= (i + 1);
                k *= (i + 2);
                i += 2;
                continue;
            }
            return res;
        }
    }
}
