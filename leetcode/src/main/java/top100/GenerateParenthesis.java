package top100;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        genParanthesis("",n,n,result);
        return result;

    }

    private void genParanthesis(String out, int open,int close, List<String> res){
        if(open==0 && close==0){
            res.add(out);
            return;
        }

        if(open>0) genParanthesis(out+"(",open-1,close,res);
        if(close>open) genParanthesis(out+")",open,close-1,res);
    }
}
