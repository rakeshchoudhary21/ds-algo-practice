package step1;

public class AllValidParenthesis {

    public static void allValidParenthesis(int N, String out, int open, int closed){
        if(open==N && closed==N){
            System.out.println(out);
            return;
        }

        if(open<N) allValidParenthesis(N,out+"(",open+1,closed);
        if(closed<open) allValidParenthesis(N,out+")",open,closed+1);
    }

    public static void allValidParenthesis2(String out, int open,int close){
        if(open==0 && close==0){
            System.out.println(out);
            return;
        }

        if(open>0 || open==close) allValidParenthesis2(out+"(",open-1,close);
        if(close>open) allValidParenthesis2(out+")",open,close-1);
    }

    public static void main(String[] args) {
        allValidParenthesis2("",3,3);
    }
}
