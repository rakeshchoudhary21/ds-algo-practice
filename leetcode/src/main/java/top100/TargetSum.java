package top100;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    /**
     * Sum caching can be added.
     * @param nums
     * @param target
     * @return
     */
    public static int targetSum(int[] nums,int target){
        return targetSum(nums,0,target);
    }

    private static int targetSum(int[] nums,int index,int sum){
        if(index==nums.length){
            if(sum==0) return 1;
        }
        if(index>=nums.length) return 0;

        int add = targetSum(nums,index+1,sum-nums[index]);
        int sub = targetSum(nums,index+1,sum+nums[index]);
        return add+sub;
    }

    public static boolean subseqSum(int[] nums, int target){
        return subseqSum(nums,0,target);
    }

    private static boolean subseqSum(int[] nums,int index, int target){
        if(target==0) return true;
        if(target<0) return false;
        for(int i=index;i<nums.length;i++){
            if(subseqSum(nums,i+1,target-nums[i])) return true;
        }
        return false;
    }

    private static boolean subarraySum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        for(int x: nums){
            sum+= x;
            if(map.containsKey(target-sum)){
                return true;
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {5,5,5};
        System.out.println(targetSum(nums,15));
        System.out.println(subseqSum(nums,15));
        System.out.println(5^5^2);

    }
}
