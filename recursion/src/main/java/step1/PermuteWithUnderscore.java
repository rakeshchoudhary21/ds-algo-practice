package step1;

import java.util.HashSet;
import java.util.Set;

public class PermuteWithUnderscore {

    private static Set<String> items = new HashSet<>();
    /**
     * Either include _ or not the letter at ith position is processed.
     * @param in
     * @param out
     */
    public static void permuteWithUnderscore(String in,String out){
        if(in.length()==0){
            if(!items.contains(out)) System.out.println(out);
            items.add(out);
            return;
        }
        if(in.length()>1) permuteWithUnderscore(in.substring(1),out+in.charAt(0)+"_");
         permuteWithUnderscore(in.substring(1),out+in.charAt(0));

    }

    public static void printWithCaseChange(String in,String out){
        if(in.length()==0){
            if(!items.contains(out)) System.out.println(out);
            items.add(out);
            return;
        }
        if(Character.isUpperCase(in.charAt(0))) printWithCaseChange(in.substring(1),out+Character.toLowerCase(in.charAt(0)));
        else printWithCaseChange(in.substring(1),out+Character.toUpperCase(in.charAt(0)));
        printWithCaseChange(in.substring(1),out+in.charAt(0));

    }

    public static void main(String[] args) {
        permuteWithUnderscore("ABC","");
        items=new HashSet<>();
        System.out.println("========================");
        printWithCaseChange("abc1","");
    }


}
