    /*
 * Дан массив целых чисел. 
 * Заменить отрицательные элементы на сумму индексов двузначных элементов массива. 
 */

package seminar2;

import java.util.Random;

public class HW_task3 {



    public static void main(String[] args) {
        int[] numbers = getNewRandomArray();
        print("Массив целых чисел :", numbers);
        int sum = getSumTwoDigitsNumbersIndexes(numbers);
        print("Сумма индексов двузначных чисел:", sum);
        modifyArray(numbers, sum);
        print("Мидификация: ", numbers);
    }

  
    private static void modifyArray(int[] numbers, int modifier) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                numbers[i] = modifier;
            }
        }
    }

     private static int getSumTwoDigitsNumbersIndexes(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if ((numbers[i] >= 10 && numbers[i] < 100) || (numbers[i] <= -10 && numbers[i] > -100)) {
                sum += i;
            }
        }
        return sum;
    }

   
    private static void print(String message, int number) {
        System.out.println(message + " " + number);
    }

    
    private static void print(String message, int[] numbers) {
        System.out.print(message);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }
        System.out.println();
    }

   
    private static int[] getNewRandomArray() {
        int length = generateRandomInt(5, 20);
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = generateRandomInt(-200, 200);
        }
        return array;
    }

   
    private static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min)) + min;
    }
}

