package top100;

import Util.Node;

public class MergeSortedLists {

    public Node<Integer> mergeTwoLists(Node<Integer> list1, Node<Integer> list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;


        if(list1.getData()<=list2.getData()){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }

    }
}
