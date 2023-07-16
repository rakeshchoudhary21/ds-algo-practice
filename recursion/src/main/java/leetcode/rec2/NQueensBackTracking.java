package leetcode.rec2;


import java.util.*;

public class NQueensBackTracking {

    private static final List<char[][]> solutions = new ArrayList<>();

    public static int totalNQueens(int n) {

        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(board[i],'.');

        backtrack(0,board,new HashSet<>(),new HashSet<>(),new HashSet<>());
        return solutions.size();

    }

    private static void backtrack(int row, char[][] board, Set<Integer> cols, Set<Integer> diag, Set<Integer> antiD){
        if(row==board.length){
            solutions.add(board);
            return;
        }

        for(int col=0;col<board[row].length;col++){
            int d = row-col;
            int anti = row+col;
            if(cols.contains(col) || diag.contains(d) || antiD.contains(anti)) continue;

            cols.add(col);
            diag.add(d);
            antiD.add(anti);
            //recursion
            backtrack(row+1,board,cols,diag,antiD);
            //backtrack
            cols.remove(col);
            diag.remove(d);
            antiD.remove(anti);
        }
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
