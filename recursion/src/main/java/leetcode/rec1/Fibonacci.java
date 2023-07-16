package leetcode.rec1;

public class Fibonacci {

    public static int fibRec(int n){
        if(n<=1) return n;
        return fibRec(n-1)+fibRec(n-2);
    }

    public static int fibIter(int n){
        if(n<=1) return n;
        int[] DP = new int[n+1];
        DP[0]=0;
        DP[1]=1;
        for(int i=2;i<=n;i++) DP[i]=DP[i-1]+DP[i-2];
        return DP[n];
    }

    public static void main(String[] args) {
        //System.out.println(fibRec(100));
        System.out.println(fibIter(41));
    }
}
