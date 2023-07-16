package top100.p2;

import java.util.Stack;

public class DecodeString {

    public static String decodeString(String str){
        String result = "";
        Stack<String> stack = new Stack<>();
        Stack<Integer> counter = new Stack<>();

        int i=0;
        while(i<str.length()){
            if(Character.isDigit(str.charAt(i))){
                //grab full number and push to counter stack
                i++;
            }else if(str.charAt(i)=='['){
                //push result to stack
                result = "";
                i++;
            }else if(str.charAt(i)==']'){
                String temp = stack.pop();
                //result = temp + result.repeat(counter.pop());
                i++;
            }else {
                result+= str.charAt(i);
                i++;
            }
        }
        return result;
    }
}
