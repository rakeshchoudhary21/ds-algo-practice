package top100;

public class LongestPalindrome {

    public static String longestPalindrome(String str){
        int start=0;
        int end=0;
        for(int i=0;i<str.length()-1;i++){
            int L = expand(str,i,i);
            int R = expand(str,i,i+1);
            int max = Math.max(L,R);
            if(max > (end-start)){
                start=i-(max-1)/2;
                end=i+max/2;
            }
        }
        return str.substring(start,end+1);
    }

    private static int expand(String str, int i, int j) {
        while(i>=0 && j<str.length() && str.charAt(i)==str.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("malayalam is super amazing language!!!!"));
    }
}
