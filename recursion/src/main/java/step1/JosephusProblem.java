package step1;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {

    //Can be solved with Queue also.
    public static void josephus(int N,int k){
        List<Integer> persons = new ArrayList<>();
        for(int i=1;i<=N;i++)
            persons.add(i);
        josephus(persons,k-1,0);
    }

    private static void josephus(List<Integer>persons,int k, int index) {
        if(persons.size()==1){
            System.out.println(persons);
            return;
        }

        index=(index+k)%persons.size();
        persons.remove(index);
        josephus(persons,k,index);
    }


    public static void main(String[] args) {
        josephus(40,7);
    }
}
