package leetcode.rec1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PowerFunc {

    public static double power(double x,int n){
        if(n>0) return helper(x,n);
        else return 1/helper(x,-n); //to make n positive
    }

    private static double helper(double x,int n){
        if(n==0) return 1.0;
        double half = helper(x,n/2); //this makes things faster since, half * half is full 1
        if(n%2==0) return half*half; //even number.
        else return half*half*x;
    }

    //It can produce the result but it will go till the last number which is not needed.
    private static double naive(double x, int n){
        if(n==0) return 1.0;
        return x * naive(x,n-1);
    }

    public static void main(String[] args) {
        log.info("2 power of 10: {}",power(2,10));
        log.info("2 power of -3: {}",power(2,-3));
        log.info("2 power of 10: {}", naive(2,10));
    }
}
