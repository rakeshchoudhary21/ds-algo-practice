package leetcode.rec1;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    private static List<Integer> pascalTriangle(int N){
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<=N;i++)
            result.add(getNumber(N,i));
        return result;
    }

    private static int getNumber(int row,int col){
        if(row==0 || col==0 || row==col) return 1;
        return getNumber(row-1,col-1)+getNumber(row-1,col);
    }

    public static void main(String[] args) {
        System.out.println(pascalTriangle(10));
    }
}
