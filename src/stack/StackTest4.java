package stack;

import java.util.Stack;

/**
 * 括号匹配
 */
public class StackTest4 {
    public static void main(String[] args) {
        String s = "12<a[b{c}]>";
        char[] sa = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        char ch;
        boolean flag = false;  //flag，最后都是false说明匹配有问题，true说明匹配是对的
        for(char c : sa) {
            if(c=='<' || c=='[' || c=='{') {
                stack.push(c);
            }

            if(c=='>' || c==']' || c== '}') {
                ch = stack.pop();
                if((ch == '<' && c == '>') || (ch == '[' && c == ']') || (ch == '{' && c == '}')) {
                    flag = true;
                }else {
                    flag = false;
                    System.out.println("符号‘" + ch + "'和符号'" + c + "'不匹配");
                }
            }
        }

        if(stack.isEmpty() && flag) {
            System.out.println("所有特殊符号都是匹配的");
        }else {
            System.out.println("特殊符号匹配有错误");
        }
    }
}
