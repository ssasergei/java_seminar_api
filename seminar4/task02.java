/*
 *  Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *  An input string is valid if:
 *  Open brackets must be closed by the same type of brackets.
 *  Open brackets must be closed in the correct order.
 *  Every close bracket has a corresponding open bracket of the same type.
 */
package seminar4;

import java.util.Stack;

public class task02 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }

    private static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char head = stack.pop();
                if ((c == ')' && head != '(') || 
                    (c == '}' && head != '{') || 
                    (c == ']' && head != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
