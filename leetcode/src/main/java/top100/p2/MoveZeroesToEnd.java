package top100.p2;

import java.util.Arrays;

public class MoveZeroesToEnd {

    public static void moveZeroes(int[] nums){
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) continue;
            nums[index++]=nums[i++];
        }

        //from index to nums.length-1 set all zeroes
        for(int k=index;k<nums.length;k++)
            nums[k]=0;
    }

    public static void main(String[] args) {
        int[] x = {1,0,1,0,1,2,3,4};
        moveZeroes(x);
        System.out.println(Arrays.toString(x));
    }
}
