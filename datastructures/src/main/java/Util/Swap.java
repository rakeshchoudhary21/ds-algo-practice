package Util;

public class Swap {

    public static void swap(char[] arr,int src,int dest){
        char temp = arr[src];
        arr[src]=arr[dest];
        arr[dest]=temp;
    }

    public static void swap(int[] arr,int src,int dest){
        int temp = arr[src];
        arr[src]=arr[dest];
        arr[dest]=temp;
    }

}
