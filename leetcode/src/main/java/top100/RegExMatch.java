package top100;

public class RegExMatch {

    /**
     * Recursive solution
     * @param str
     * @param pattern
     * @return
     */
    public static boolean regExRecursively(String str,String pattern){
        if(pattern.length()==0) return str.length()==0;

        boolean match = str.length()>0 && str.charAt(0)==pattern.charAt(0) || pattern.charAt(0)=='.';
        if(pattern.length()>=2 && pattern.charAt(1)=='*'){
            //either we don't need the * at all. or we need it, if we need it then we need to ensure current char matches
            return regExRecursively(str,pattern.substring(2)) || (match && regExRecursively(str.substring(1),pattern));
        }
        return match && regExRecursively(str.substring(1),pattern.substring(1));
    }

    /**
     * DP solution for same problem. go thru this
     * @param s
     * @param p
     * @return
     */
    public static boolean dpSolution(String s,String p){
        int M = s.length();
        int N = p.length();
        boolean[][] T = new boolean[M+1][N+1];
        T[0][0]=true;
        for(int i=2;i<=N;i++)
            if(p.charAt(i-1)=='*')
                T[0][i]=T[0][i-2];


        for(int i=1;i<=M;i++){
            for(int j=1;j<=N;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || (p.charAt(j-1)=='.')) T[i][j]=T[i-1][j-1];
                else {
                    if(p.charAt(j-1)=='*'){
                        if(T[i][j-2]) T[i][j]=T[i][j-2];
                        else if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.')
                            T[i][j]=T[i-1][j];
                    }
                }
            }
        }
        return T[M][N];
    }

    public static void main(String[] args) {
         String s= "bab", p = "b*ab";
        System.out.println(regExRecursively(s,p));
    }
}
