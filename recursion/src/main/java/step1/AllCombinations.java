package step1;

import Util.Swap;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AllCombinations {

    static Set<String> result = new LinkedHashSet<>();
    /**
     * We will process each char by both adding it into output and by not adding it to output. That we process both possibilities for each char.
     * @param input input
     * @param output output as we process char by char
     */
    public static void printAllCombinations(String input,String output){
        if(input.length()==0) {
            result.add(output);
            return;
        }

        printAllCombinations(input.substring(1),output);
        printAllCombinations(input.substring(1),output+input.charAt(0));
    }

    /**
     * 123 -> 213 -> 321 -> 132 -> 231
     */
    public static void allPermutations(String input,int j){
        if(j==input.length()){
            System.out.println(input);
            return;
        }

        for(int i=j;i<input.length();i++){
            char[] arr = input.toCharArray();
            Swap.swap(arr,i,j);
            allPermutations(new String(arr),j+1);
            Swap.swap(arr,i,j);
        }
    }

    //incremental processing. check this out.
    public static void subStrings(List<Character> input){
        for(int i=0;i<input.size();i++)
            for(int j=0;j<input.size();j++){
                String res = "";
                for(int k=i;k<=j;k++)
                    res+=input.get(k);
                if(res.length()>0) System.out.println(res);
            }

    }


    public static void main(String[] args) {
        printAllCombinations("ABC","");
        System.out.println("result:"+result);
        allPermutations("abc",0);
        LinkedList<Character> list = new LinkedList<>();
        list.add('1');
        list.add('2');
        list.add('3');
        subStrings(list);
    }
}
