package leetcode.rec1;

import Util.CustomLinkedList;
import Util.Node;

public class MergeSortedLists {

    public static Node<Integer> mergeSortedLists(Node<Integer> list1, Node<Integer> list2){
        if(list1==null) return list2;
        if(list2==null) return list1;

        if(list1.data<=list2.data){
            list1.next = mergeSortedLists(list1.next,list2);
            return list1;
        }else{
            list2.next = mergeSortedLists(list1,list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(1);
        customLinkedList.add(2);
        customLinkedList.add(3);
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(30);

        CustomLinkedList<Integer> customLinkedList2 = new CustomLinkedList<>();
        customLinkedList2.add(4);
        customLinkedList2.add(5);
        customLinkedList2.add(6);
        //default its adding in reverse order.
        Node<Integer> merged = mergeSortedLists(ReverseList.reverse(customLinkedList.getHead()),ReverseList.reverse(customLinkedList2.getHead()));
        System.out.println(merged);

    }
}
