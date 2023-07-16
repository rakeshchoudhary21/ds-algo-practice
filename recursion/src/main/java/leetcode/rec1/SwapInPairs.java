package leetcode.rec1;

import Util.CustomLinkedList;
import Util.Node;

public class SwapInPairs {

    public static Node<Integer> swap(Node<Integer> head){
        if(head==null || head.next==null) return head;

        Node<Integer> second = head.next;
        Node<Integer> rec = second.next;
        second.next=head; //this lines location doesn't matter
        head.next=swap(rec);
        return second;
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> custom = new CustomLinkedList<>();
        custom.add(10);
        custom.add(20);
        custom.add(30);
        custom.display();
        Node<Integer> head = swap(custom.head);
        System.out.println(head);
    }
}
