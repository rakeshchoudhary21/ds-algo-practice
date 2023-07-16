package step1;

import java.util.Stack;

public class DeleteKthItem {

    public static void deleteKthItem(Stack<Integer> stack,int k){
        if(k>stack.size()) return;

        delete(stack,k);
    }

    private static void delete(Stack<Integer> stack, int k) {
        if(k==0){
            stack.pop();
            return;
        }

        int top = stack.pop();
        delete(stack,k-1);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(11);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        deleteKthItem(stack,3);
        System.out.println(stack);
    }


}
