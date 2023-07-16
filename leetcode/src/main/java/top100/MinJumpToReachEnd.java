package top100;

public class MinJumpToReachEnd {

    public static int minJumps(int[] nums){
        int jumps=0;
        int currEnd=0;
        int farthest=0;

        for(int i=0;i<nums.length-1;i++){
            farthest = Math.max(farthest,i+nums[i]);
            if(currEnd == i){
                jumps++;
                currEnd=farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,1,1,5};
        System.out.println(minJumps(nums));
    }
}
