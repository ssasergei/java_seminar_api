/*
 * ДЗ:
 * 1)Вывести список на экран в перевернутом виде (без массивов и ArrayList)
 * Пример:
 * 1 -> 2->3->4
 * Вывод:
 * 4->3->2->1
 */

package seminar4;

import java.util.LinkedList;

public class task01 {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };
        LinkedList<Integer> list = GetList(array);
        System.out.println(Join(" -> ", list));
        System.out.println(Join(" -> ", Reverse(list)));
    }

    /**
    * Получает связанный список из массива 
    *
    * @param params
    * @return
    */
    private static LinkedList<Integer> GetList(int[] params) {
        LinkedList<Integer> list = new LinkedList<>();
        for (Integer item : params) {
            list.add(item);
        }
        return list;
    }

    /**
     * Инвертирует связанный список
     * 
     * @param input
     * @return
     */
    private static LinkedList<Integer> Reverse(LinkedList<Integer> input) {
        LinkedList<Integer> output = new LinkedList<>();
        while (!input.isEmpty()) {
            output.add(input.removeLast());
        }
        return output;
    }

    /**
     * Получить строку из связанного списка с разделителем
     * 
     * @param data
     * @return
     */
    private static String Join(String separator, LinkedList<Integer> data) {
        StringBuilder builder = new StringBuilder();
        for (Integer item : data) {
            builder.append(item + separator);
        }
        String result = builder.toString();
        return result.substring(0, result.length() - 4);
    }
}
