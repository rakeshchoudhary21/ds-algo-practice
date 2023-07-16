package top100;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChar {

    public static int longestSubstrWithoutRepeatingChar(String s){
        int max=0;
        int i=0; //goes one char at a time.
        int j=0; //moves till end for each ith char
        Set<Character> set = new HashSet<>();
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                max = Math.max(max,set.size());
                j++;
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstrWithoutRepeatingChar("abcdaef"));
    }
}
