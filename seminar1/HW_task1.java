 package seminar1;

/*  
* Given an input string s, reverse the order of the words.
* A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
* Return a string of the words in reverse order concatenated by a single space.
* Note that s may contain leading or trailing spaces or multiple spaces between two words. 
* The returned string should only have a single space separating the words. Do not include any extra spaces.
*/

public class HW_task1 {
        public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("a good   example"));
    }

    /**
     * 
     * @param input -> input string
     * @return -> reversed words in a line
     */
    public static String reverseWords(String input) {
        String[] arrayStrings = input.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = arrayStrings.length - 1; i >= 0; i--) {
            if(!arrayStrings[i].equals(""))
                builder.append(arrayStrings[i].trim() + " ");
        }
        return builder.toString().trim();
    }
}