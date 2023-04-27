package seminar3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class hw_task4 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = getRandomIntegers();
        int min = getMin(integers);
        int max = getMax(integers);
        int sum = getSum(integers);
        double avg = (double) sum / integers.size();
        List<Integer> even = getFiltered(integers, item -> (item % 2) == 0);
        List<Integer> odd = getFiltered(integers, item -> (item % 2) == 1);
        List<Integer> biggerThan50 = getFiltered(integers, item -> (item > 50));

        System.out.println("Input data: " + integers);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        System.out.println("Amount: " + sum);
        System.out.println("Average: " + avg);
        System.out.println("Only even: " + even);
        System.out.println("Only odd: " + odd);
        System.out.println("biggerThan50: " + biggerThan50);
    }

    /**
     * поиск минимального значения
     * 
     * @param integers
     * @return
     */
    private static int getMin(ArrayList<Integer> integers) {
        int min = integers.get(0);
        for (int i = 1; i < integers.size(); i++) {
            if (min > integers.get(i)) {
                min = integers.get(i);
            }
        }
        return min;
    }

    /**
     * поиск максимального значения
     * 
     * @param integers
     * @return
     */
    private static int getMax(ArrayList<Integer> integers) {
        int max = integers.get(0);
        for (int i = 1; i < integers.size(); i++) {
            if (max < integers.get(i)) {
                max = integers.get(i);
            }
        }
        return max;
    }

    /**
     * получение суммы элементов
     * 
     * @param integers
     * @return
     */
    private static int getSum(ArrayList<Integer> integers) {
        int sum = 0;
        for (int i = 0; i < integers.size(); i++) {
            sum += integers.get(i);
        }
        return sum;
    }

    /**
     * выборка значений по фильтру
     */
    private static List<Integer> getFiltered(ArrayList<Integer> integers, Expression func) {
        List<Integer> numbers = new ArrayList<>();
        for (Integer integer : integers) {
            if (func.Check(integer)) {
                numbers.add(integer);
            }
        }
        return numbers;
    }

    /**
     * получение случайного списка целых чисел
     * 
     * @return
     */
    private static ArrayList<Integer> getRandomIntegers() {
        int length = generateRandomInt(5, 15);
        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            data.add(generateRandomInt(10, 100));
        }
        return data;
    }

    /**
     * генерирует случайно число в диапазоне
     */
    private static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    /**
     * функциональный интерфейс для лямбда выражения
     */
    interface Expression {
        boolean Check(int n);
    }
}