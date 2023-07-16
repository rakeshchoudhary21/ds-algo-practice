package leetcode.rec2;


import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

@Slf4j
public class Combinations {

    /**
     * https://leetcode.com/problems/combinations/
     * Generate combinations of k numbers till given number
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combinations(int n,int k){
        List<List<Integer>> answer = new LinkedList<>();
        combinations(1,n,k,new LinkedList<>(),answer);
        log.info("Result:"+answer);
        return answer;
    }

    private static void combinations(int start,int n,int k,LinkedList<Integer> temp, List<List<Integer>> answer){
        if(temp.size()==k) answer.add(new LinkedList<>(temp));
        for(int i=start;i<=n;i++){
            temp.add(i);
            combinations(i+1,n,k,temp,answer);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        combinations(4,2);

    }
}
