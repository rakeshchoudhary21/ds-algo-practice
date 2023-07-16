package step1;

public class BinaryDigits {

    public static void moreOrEqualOnesThanZeroes(int total,int zeroes,int ones,String out){
        if(total==0){
            System.out.println(out);
            return;
        }

        //we need to start with a one, and we can use as many ones as possible(till total drops to zero).
        moreOrEqualOnesThanZeroes(total-1,zeroes,ones+1,out+"1");
        //zeroes should be added only if they are less than ones
        if(zeroes < ones) moreOrEqualOnesThanZeroes(total-1,zeroes+1,ones,out+"0");
    }

    public static void main(String[] args) {
        moreOrEqualOnesThanZeroes(3,0,0,"");
    }
}
