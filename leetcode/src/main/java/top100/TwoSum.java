package top100;

import java.util.*;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 * @leetcode https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    //brute force
    public static int[] twoSum(int[] arr,int target){
        int[] result = new int[2];
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return null;
    }

    public static int[] twoSumBetter(int[] arr,int target){
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(target-arr[i])){
                result[0]=i;
                result[1]=map.get(target-arr[i]);
                return result;
            }
            map.put(arr[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr={3,2,1,6};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr,target)));
        System.out.println(Arrays.toString(twoSumBetter(arr,target)));

    }

}
