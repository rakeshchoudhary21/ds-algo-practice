package leetcode.rec2;

import java.util.Arrays;

import static Util.Swap.swap;
import static leetcode.rec2.SortingAlgos.MergeSort.mergeSort;
import static leetcode.rec2.SortingAlgos.QuickSort.quickSort;

public class SortingAlgos {

    static class MergeSort{
        public static void mergeSort(int[] arr,int low,int high){
            if(low>=high) return;
            int mid = low + (high-low)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }

        private static void merge(int[] arr, int low, int mid, int high) {
            int lowStart = low;
            int lowEnd = mid;
            int highStart = mid+1;
            int highEnd = high;
            int[] temp = new int[arr.length];
            int count=low;
            while(lowStart<=lowEnd && highStart<=highEnd){
                if(arr[lowStart]<=arr[highStart]) temp[count++]=arr[lowStart++];
                else temp[count++]=arr[highStart++];
            }

            while(lowStart<=lowEnd) temp[count++]=arr[lowStart++];
            while (highStart<=highEnd) temp[count++]=arr[highStart++];

            for(int i=low;i<=high;i++)
                arr[i]=temp[i];
        }
    }

    static class QuickSort{

        public static void quickSort(int[] arr,int low,int high){
            if(low>high) return;

            int pivot = arr[low];
            int left=low;
            int right=high;
            while(left<right){
                while(arr[left]<=pivot && left<right) left++;
                while (arr[right]>pivot && right>=left) right--;
                if(left<right) swap(arr,left,right);
            }

            swap(arr,right,low);
            quickSort(arr,low,right-1);
            quickSort(arr,right+1,high);
        }
    }

    //This version of Merge sort is extremely fast
    static class AnotherMergeSort{
        public static int[] mergeSort(int[] input){
            if(input.length <= 1) return input;

            int mid = input.length/2;
            int[] left = mergeSort(Arrays.copyOfRange(input,0,mid));
            int[] right = mergeSort(Arrays.copyOfRange(input,mid,input.length));
            return merge(left,right);
        }

        private static int[] merge(int[] left,int[] right){
            int[] temp = new int[left.length+right.length];
            int lIndex=0;
            int rIndex=0;
            int tempIndex=0;
            while(lIndex<left.length && rIndex<right.length){
                if(left[lIndex] <= right[rIndex]) temp[tempIndex++]=left[lIndex++];
                else temp[tempIndex++]=right[rIndex++];
            }
            while (lIndex<left.length) temp[tempIndex++]=left[lIndex++];
            while (rIndex<right.length) temp[tempIndex++]=right[rIndex++];
            return temp;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,2,0,-1};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {1,0,2};
        quickSort(arr2,0,arr2.length-1);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = {1,0,2};
        AnotherMergeSort.mergeSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
