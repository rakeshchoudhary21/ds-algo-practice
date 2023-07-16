package step1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class AllSusequences {

    /**
     * All combinations are nothing but all subsequences
     * Powerset, subsets and subseq are all same
     * If unique subseq is asked then just use a set to discard duplicates
     * @param str
     * @param out
     */
    public static void printAllSubseq(String str,String out){
        if(str.equalsIgnoreCase("")){
            System.out.println(out);
            return;
        }
        printAllSubseq(str.substring(1),out+str.charAt(0));
        printAllSubseq(str.substring(1),out);
    }

    public static void powerSets(LinkedList<Character> items, String out,int index){
        if(index == items.size()) {
            System.out.println(out);
            return;
        }
        powerSets(items,out+items.get(index),index+1);
        powerSets(items,out,index+1);
    }

    static Set<String> set = new HashSet<>();
    public static void uniqueSubSets(LinkedList<Character> items, String out,int index){
        if(index==items.size()) {
            set.add(out);
            return;
        }
        uniqueSubSets(items,out+items.get(index),index+1);
        uniqueSubSets(items,out,index+1);
    }


    public static void main(String[] args) {
        printAllSubseq("ABC","");
        LinkedList<Character> list = new LinkedList<>();
        list.add('1');
        list.add('1');
        list.add('3');
        powerSets(list,"",0);
        uniqueSubSets(list,"",0);
        System.out.println(set);

    }

}
