package leetcode.rec1;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ClimbingStairs {

    public static int climbingStairs(int n){
        if(n<=2) return n;
        return climbingStairs(n-1)+climbingStairs(n-2);
    }

    public static void main(String[] args) {
        log.info("Res:"+climbingStairs(10));
    }
}
