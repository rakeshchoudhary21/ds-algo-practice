package step1;

import java.util.LinkedList;
import java.util.Stack;

public class SortWithRecursion {

    private static void sort(LinkedList<Integer> list){
        if(list.isEmpty()) return;
        //make no diff if you remove first item or last.
        int item = list.remove();
        sort(list);
        insertRec(list,item);
    }

    private static void insertRec(LinkedList<Integer> list, int item){
        if(list.isEmpty() || list.getLast()<=item){
            list.addLast(item);
            return;
        }

        int last = list.removeLast();
        insertRec(list,item);
        list.addLast(last);
    }

    private static void sortStack(Stack<Integer> stack){
        if(stack.size()==1) return;
        int top = stack.pop();
        sortStack(stack);
        insertStk(stack,top);
    }

    private static void insertStk(Stack<Integer> stack,int item){
        if(stack.isEmpty() || stack.peek()<=item){
            stack.push(item);
            return;
        }

        int large = stack.pop();
        insertStk(stack,item);
        stack.push(large);
    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(5);
        list.add(3);
        list.add(2);
        list.add(6);
        sort(list);
        System.out.println(list);
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(11);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(5);

        sortStack(stack);
        System.out.println(stack);
    }
}
