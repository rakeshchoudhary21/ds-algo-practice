package leetcode.rec2;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        genParenthesis("",n,n,result);
        log.info("Result:{}",result);
        return result;
    }

    private static void genParenthesis(String s, int open, int close, List<String> result) {
        if(open==0 && close==0) {
            result.add(s);
            return;
        }

        if(open>0) genParenthesis(s+"(",open-1,close,result);
        if(close>open) genParenthesis(s+")",open,close-1,result);
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
