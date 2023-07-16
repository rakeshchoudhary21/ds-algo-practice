package top100;

public class MedianOfTwoSortedArrays {

    public static double medianOfTwoSortedArrays(int[] a,int[] b){
        int[] merge = merge(a,b);
        if(merge.length%2!=0) return merge[merge.length/2];
        else return (merge[merge.length/2] + merge[merge.length/2 -1])/2.0;
    }

    private static int[] merge(int[] a, int[] b){
        int[] res = new int[a.length+b.length];
        int i=0;
        int j=0;
        int counter=0;
        while(i<a.length && j<b.length){
            if(a[i]<=b[j]) res[counter++]=a[i++];
            else res[counter++]=b[j++];
        }

        while(i<a.length) res[counter++]=a[i++];
        while(j<b.length) res[counter++]=b[j++];
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {2,3,4};
        System.out.println(medianOfTwoSortedArrays(a,b));
    }
}
