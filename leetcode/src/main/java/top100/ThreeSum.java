package top100;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

    /**
     * Three Sum equal to Zero
     * @param nums
     * @return
     */
    public static ArrayList<Object> threeSum(int[] nums) {

        ArrayList<Object> result = new ArrayList<Object>();

        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                int temp = nums[i]+nums[j]+nums[k];
                if(temp == 0) {
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k && nums[j]==nums[j+1]) j++;
                    while(j<k && nums[k]==nums[k-1]) k--;
                }
                if(temp>0) k--;
                else j++;
            }
            while(i<n-1 && nums[i]==nums[i+1]) i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(input));
    }
}
