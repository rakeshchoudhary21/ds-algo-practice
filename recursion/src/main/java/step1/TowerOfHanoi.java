package step1;

public class TowerOfHanoi {

    private static void towerOfHanoi(int disks,int src,int dest,int temp){
        if(disks==1) {
            //last disk goes to dest
            System.out.println("moving disk "+disks+" from "+src+" to "+dest);
            return;
        }
        //n-1 disks need to go from src to temp
        towerOfHanoi(disks-1,src,temp,dest);
        System.out.println("moving disk "+disks+" from "+src+" to "+dest);
        //after last disk moved, we move n-1 disks from temp to dest
        towerOfHanoi(disks-1,temp,dest,src);
    }

    private static int tOHSteps(int disks,int src,int dest,int temp){
        if(disks==1) {
            //last disk goes to dest
            //System.out.println("moving disk "+disks+" from "+src+" to "+dest);
            return 1;
        }
        //n-1 disks need to go from src to temp
        return 1+tOHSteps(disks-1,src,temp,dest) + tOHSteps(disks-1,temp,dest,src);

    }

    public static void main(String[] args) {
        towerOfHanoi(12,0,2,1);
        System.out.println(tOHSteps(12,0,2,1));
    }
}
