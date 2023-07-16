package top100.p2;

import java.util.Arrays;
import java.util.Collections;

public class NumberOfPalindromicSubs {

    public static int numberOfPalindromicSubstrings(String s){
        int count=0;
        for(int i=0;i<s.length();i++)
            count+= expand(s,i,i)+expand(s,i,i+1);
        return count;
    }

    private static int expand(String s, int low, int high) {
        int count=0;
        while(low>=0 && high<s.length() && s.charAt(low)==s.charAt(high)){
            low--;
            high++;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfPalindromicSubstrings("abba"));
        System.out.println(Collections.max(Arrays.asList(1,100,3)));
    }
}
