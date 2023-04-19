package seminar1;

public class HW_task2 {
    public static void main(String[] args) {
        String input1 = "1 2 1 2 -1 1 3 1 3 -1 0";
       
        System.out.println(String.format("INPUT: -> \"%s\" OUTPUT -> %s", input1, getSumPositiveNumbers(input1)));
       
    }

    /**
     * 
     * @return the sum of positive numbers, if there is a negative next to it
     */
    public static int getSumPositiveNumbers(String inputString){
        String[] arrayStrings = inputString.split(" ");
        int sum = 0;
        for (int i = 0; i < arrayStrings.length - 1; i++) {
            int number = Integer.parseInt(arrayStrings[i]);
            if(number == 0) break;
            int next = Integer.parseInt(arrayStrings[i + 1]);
            if(number > 0 && next < 0) sum += number;
        }                
        return sum;
    }
 }
