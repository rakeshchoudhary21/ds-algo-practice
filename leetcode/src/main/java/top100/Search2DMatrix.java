package top100;

import java.util.ArrayList;
import java.util.List;

public class Search2DMatrix {

    /**
     * Matrix is sorted horizontally as well as vertically.
     * @param arr
     * @param start
     * @param key
     * @param vertical
     * @return
     */
    private static boolean binarySearch(int[][] arr, int start,int key, boolean vertical){
        int low=start;
        int high = (vertical?arr[0].length:arr.length)-1;

        while (high>=low){
            int mid = (low+high)/2;
            if(vertical){
                if(arr[start][mid]<key) low=mid+1;
                else if(arr[start][mid]>key) high=mid-1;
                else return true;
            }else{
                if(arr[mid][start]< key) low=mid+1;
                else if(arr[mid][start]>key) high=mid-1;
                else return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] mat = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        //we go diagonal wise
        for(int i=0;i<Math.min(mat.length,mat[0].length);i++){
            if(binarySearch(mat,i,14,false) || binarySearch(mat,i,16,true)) {
                System.out.println("Found at::"+i);
                break;
            }
        }
    }
}
