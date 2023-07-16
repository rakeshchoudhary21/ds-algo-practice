package sides;

public class JumpGame {

    public static boolean possibleToReachEnd(int[] jumps){
        int end = 0;
        for(int i=0;i<=end;i++){
            end=Math.max(end,i+jumps[i]);
            if(end>=jumps.length) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] jumps = {1,1,1,2,3,1};
        System.out.println(possibleToReachEnd(jumps));
    }

}
