package step1;

import java.util.Scanner;

public class KthGrammarSymbol {

    /**
     * Grammar is generated recursively, and start point is 1 row 1 symbol=0,
     * next row is by rule-> 0 becomes 0,1 and 1 becomes 1,0
     * @param n
     * @param k
     * @return
     */
    public static int kthSymbol(int n,int k){
        if(n==1 || k==1) return 0;

        int mid = (int)Math.pow(2,n-1)/2;

        //first half of each row is same as row above it. so just call for n-1, rest is complement
        if(k<=mid) return kthSymbol(n-1,k);
        else return kthSymbol(n-1,k-mid)==1?0:1;
    }

    public static void main(String[] args) {
        System.out.println(kthSymbol(3,4));
        Scanner scanner = new Scanner(System.in);
        int next;
        while ((next=scanner.nextInt())!=1){
            System.out.println(next);
        }
    }
}
