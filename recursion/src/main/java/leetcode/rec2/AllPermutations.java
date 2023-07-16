package leetcode.rec2;


import java.util.ArrayList;
import java.util.List;

import static Util.Swap.swap;

public class AllPermutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        allPermutations(0,nums.length,nums,result);
        return result;
    }

    void allPermutations(int index,int N, int[] nums, List<List<Integer>> result){
        if(index==N){
            List<Integer> temp = new ArrayList<>();
            for(int x:nums) temp.add(x);
            result.add(temp);
        }

        for(int k=index;k<N;k++){
            swap(nums,index,k);
            allPermutations(index+1,N,nums,result);
            swap(nums,index,k);
        }
    }

}
