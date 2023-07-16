package sides;

import java.util.Arrays;

public class StringToNumber {

    /**
     * Convert string to number.
     * @param str
     * @return
     */
    public static int number(String str){
        int res=0;
        for(int i=0;i<str.length();i++){
            res= 10*res + (str.charAt(i)-'0');
        }
        return res;
    }

    /**
     * Reverses a given int
     * @param input
     * @return
     */
    public static int reverseNumber(int input){
        int t=input;
        int rev=0;
        while(t!=0){
            rev = rev*10 + t%10;
            t/=10;
        }
        return rev;
    }


    public static void main(String[] args) {

        System.out.println(number("123456"));
        System.out.println(reverseNumber(987));

        boolean[] haves = new boolean[6];
        for(int x: new int[]{1,2,4,5}){
            if(x>=0 && x<=5) haves[x]=true;
        }
        System.out.println(Arrays.toString(haves));
    }
}
