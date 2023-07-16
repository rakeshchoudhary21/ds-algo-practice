package top100;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c: chars){
            switch (c){
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.peek()!='(') return false;
                    stack.pop();
                    break;
                case '}':
                    if(stack.isEmpty() || stack.peek()!='{') return false;
                    stack.pop();
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek()!='[') return false;
                    stack.pop();
                    break;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("is valid:"+isValid("(((())))"));

    }
}
