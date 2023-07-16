package leetcode.rec2;

import java.util.ArrayDeque;

public class LargestRectangleArea {

    public static int largesRectangleArea(int[] h){
        int maxArea = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int i=0;
        while(i<h.length){
            //cliff or empty (wrt stack)
            while(i<h.length && (stack.isEmpty() || h[i] >= h[stack.peek()]))
                stack.push(i++);
            //reached length or hit ascend (wrt stack)
            while(!stack.isEmpty() && (i==h.length || h[i] < h[stack.peek()])){
                int top = stack.pop();
                int topArea = h[top] * (stack.isEmpty()?i: i-stack.peek()-1);
                maxArea = Math.max(maxArea,topArea);
            }
        }
        return maxArea;
    }
}
