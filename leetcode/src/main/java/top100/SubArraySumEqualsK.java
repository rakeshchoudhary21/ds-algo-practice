package top100;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    public static int bruteForce(int[] arr,int k){
        int result=0;
        for(int i=0;i<arr.length;i++) {
            int sum = 0;
            for (int j=i; j<arr.length;j++){
                sum+=arr[j];
                if(k==sum) result++;
            }
        }
        return result;
    }

    //single pass
    public static int subArraySumEqualsK(int[] arr,int K){
        int sum=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int result=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum-K))  result+=map.get(sum-K);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,6,7};
        System.out.println(subArraySumEqualsK(arr,4));
        System.out.println(bruteForce(arr,4));

    }
}
