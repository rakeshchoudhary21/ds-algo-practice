package top100.p2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Properties;

public class SlidingWindowMax {

    public static int[] slidingWindow(int[] arr,int k){
        int[] res = new int[arr.length+1-k];
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int index=0;
        for(int i=0;i< arr.length;i++) {
            while(!deq.isEmpty() && arr[deq.getFirst()]< arr[i])
                deq.removeLast();

            deq.addLast(i);
            if(!deq.isEmpty() && deq.getFirst()<=(i-k)) deq.removeFirst();
            if(i>= k-1) res[index++]=arr[deq.getFirst()];
        }

        return res;
    }

    private static void reverse(int x){
        int rev=0;
        while(x>0){
            rev = rev*10 + (x%10);
            x/=10;
        }
        System.out.println(rev);
    }

    public static void main(String[] args) {
        int[] q = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(slidingWindow(q,k)));
        reverse(12);
        Properties p = new Properties();
        p.setProperty("a","a");
        p.setProperty("b","b");
        Properties p2 = new Properties();
        p2.setProperty("x","y");
        p2.putAll(p);
        System.out.println(p2);

    }
}
