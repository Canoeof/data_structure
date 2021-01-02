package stack;
/**
 * 反转字符串
 */

import java.util.Stack;

public class StackTest3 {
    public static void main(String[] args) {
        String s = "How are you";
        char[] sa = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : sa) {
            stack.push(c);
        }

        System.out.println(s);
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
