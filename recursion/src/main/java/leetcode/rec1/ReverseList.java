package leetcode.rec1;

import Util.CustomLinkedList;
import Util.Node;

public class ReverseList {

    public static Node<Integer> reverse(Node<Integer> head){
        if(head==null || head.next==null) return head;
        Node<Integer> temp = reverse(head.next);
        head.next.next=head;
        head.next=null;
        return temp;
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> custom = new CustomLinkedList<>();
        custom.add(10);
        custom.add(20);
        custom.add(30);
        custom.add(40);
        System.out.println(custom.head);
        Node<Integer> res = reverse(custom.getHead());
        System.out.println(res);
    }
}
