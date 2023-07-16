package top100;

public class NumberOfIslands {

    public static int islands(int[][] matrix){
        int count=0;
        for(int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                    bfs(matrix, i, j);
                }
            }
        }
        return count;
    }

    private static void bfs(int[][] matrix,int row,int col){
        if(row<0 || row>=matrix.length || col<0 || col>=matrix[row].length || matrix[row][col]!=1) return;

        matrix[row][col]=0;
        bfs(matrix,row-1,col);
        bfs(matrix,row+1,col);
        bfs(matrix,row,col-1);
        bfs(matrix,row,col+1);
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {0,1,1},
                {1,0,1},
                {0,0,0},
                {1,0,1}
        };
        System.out.println(islands(matrix));
    }
}
