package leetcode.rec1;

import Util.Swap;

import java.util.Arrays;

public class ReverseString {

    public static void reverse(char[] str){
        reverse(str,0,str.length-1);
    }

    private static void reverse(char[] str, int low, int high) {
        if(low>high) return;
        Swap.swap(str,low,high);
        reverse(str,low+1,high-1);
    }

    private static String reverse(String str){
        if(str.length()==0) return str;
        else return str.charAt(str.length()-1) + reverse(str.substring(0,str.length()-1));
    }

    public static void main(String[] args) {
        char[] input = "AMA".toCharArray();
        reverse(input);
        System.out.println(Arrays.toString(input));
        System.out.println(reverse("abc"));
        System.out.println(reverse("abcd"));

    }
}
