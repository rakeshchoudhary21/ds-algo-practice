package top100;

public class LargestContainerByArea {

    public static int largestContainerArea(int[] hist){
        int lArea=0,rArea=0,maxArea=0;
        int i=0;
        int j=hist.length-1;
        while(i<=j){
            if(hist[i]<=hist[j]) lArea = hist[i] * (j-i);
            if(hist[i]>hist[j]) rArea = hist[j] * (j-i);
            maxArea = Math.max(maxArea,Math.max(lArea,rArea));
            if(hist[i]>hist[j]) j--;
            else i++;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        assert largestContainerArea(new int[]{4,3,2,1,4})==16:"Failed";
    }
}
