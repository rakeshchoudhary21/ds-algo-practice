package top100.p2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartitionSumDP {

    public static boolean partitionSum(int[] arr){
        int sum = Arrays.stream(arr).sum();
        if(sum%2 != 0) return false; //partition can't be had

        int target = sum/2; //this is target we need to find a partition with

        boolean[][] DP = new boolean[arr.length+1][target+1];

        for(int i=0;i<=arr.length;i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0 || j == 0) DP[i][j] = false;
                else if(arr[i-1] > j) DP[i][j] = DP[i-1][j];
                else if(arr[i-1] == j) DP[i][j] = true;
                else DP[i][j] = DP[i-1][j] | DP[i][j-1];
            }
        }


        return DP[arr.length][target];
    }

    public static void main(String[] args) {
        int[] arr = {5,6};
        System.out.println(partitionSum(arr));

        System.out.println(1/3);
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        String s = "abc";
        int i=0;
        map.computeIfAbsent(i, (x)-> s.indexOf(i));
        System.out.println(map);

    }
}
