package top100;

import java.util.LinkedHashMap;

public class SingleDupNumber {

    /**
     * Single item is not duplicate in given list. return that number
     * @param nums
     * @return
     */
    public static int singleDup(int[] nums){
        int x=0;
        for(int a: nums) x^=a;
        return x;
    }

    public static void main(String[] args) {
        int[] items = {1,4,4};
        int x=0;
        for(int a: items){
            x^=a;
            System.out.println("a:"+a+"\t"+x);
        }

        LinkedHashMap<Integer,Integer> lhm = new LinkedHashMap<>();

    }
}
