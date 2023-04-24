package seminar2;
/*
 * Задача 1
 * Дана последовательность N целых чисел. Найти сумму простых чисел
 */

import java.util.Scanner;
public class HW_task1 {
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("сумму простых чисел " + getSum());
        sc.close();
    }

    
    public static int getSum() {
        int sum = 0;
        int number = -1;
        while ((number = getNextInput()) > 1) {
            if (isPrime(number)) {
                sum += number;
            }
        }
        return sum;
    }

        public static int getNextInput() {
        System.out.println("Введите число: ");
        return sc.nextInt();
    }

    
    public static boolean isPrime(int number) {
        for (int divider = 2; divider <= (int) Math.sqrt(number); divider++) {
            if (number % divider == 0) {
                return false;
            }
        }
        return true;
    }
}
