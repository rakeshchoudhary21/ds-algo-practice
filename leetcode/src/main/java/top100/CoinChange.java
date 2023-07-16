package top100;

import sun.security.provider.MD5;

import java.util.Arrays;

public class CoinChange {

    /**
     * Min coins needed to make given change. There is infinite supply of coins of given denomination
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins,int amount){
        int[] DP = new int[amount+1];
        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[0]=0;
        for(int i=1;i<=amount;i++){
            for(int coin: coins){
                if(coin<=i){
                    int rem = DP[i-coin];
                    if(rem !=Integer.MAX_VALUE && rem+1 < DP[i])
                        DP[i]=rem+1;
                }
            }
        }
        return DP[amount];
    }


    private static int hash1(String str){
        return Math.abs(str.hashCode())%100;
    }

    private static int hash2(String str){
        int hash=0;
        for(int i=0;i<str.length();i++)
            hash+=str.charAt(i) * Math.pow(31,i);
        return Math.abs(hash)%100;
    }
    public static void main(String[] args) {
        int[] coins = {1,2,3,6};
        System.out.println(coinChange(coins,9));

        System.out.println(hash1("Rakesh")+"\t"+hash2("Rakesh"));

        // => Hash the requests to a (0-Big Ass N). Also hash Available Servers to 0 -> N creating K points.
        // Each request is then served by nearest available K point.

    }
}
