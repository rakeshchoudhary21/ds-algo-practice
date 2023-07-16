package leetcode.rec2;

public class SearchInSorted2dMatrix {

    //Iterate over diagonal, search horizontal and vertical in each iteration.
    public static boolean searchMatrix(int[][] matrix, int target){
        if(matrix==null || matrix.length==0) return false;

        int diag = Math.min(matrix.length,matrix[0].length);
        for(int i=0;i<diag;i++){
            boolean searchVertically = binarySearch(matrix,target,i,false);
            boolean searchHorizontal = binarySearch(matrix,target,i,true);
            if(searchHorizontal || searchVertically) return true;
        }
        return false;
    }

    private static boolean binarySearch(int[][] matrix,int target,int start,boolean horizontal){
        int low = start;
        int high = (horizontal?matrix[0].length:matrix.length)-1;

        while (low<high){
            int mid = low + (high-low)/2;
            if(horizontal){
                if (matrix[mid][start] < target) low = mid+1;
                else if (matrix[mid][start] > target) high = mid-1;
                else return true;
            }else{
                if (matrix[start][mid] < target) low = mid + 1;
                else if (matrix[start][mid] > target) high = mid - 1;
                else return true;
            }
        }
        return false;
    }
}
