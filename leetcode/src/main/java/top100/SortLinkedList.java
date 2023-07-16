package top100;

import Util.CustomLinkedList;
import Util.Node;

public class SortLinkedList {
    //use merge sort. its amazing

    static Node<Integer> mergeSort(Node<Integer> head){
        if(head == null || head.next==null) return head;

        Node<Integer> mid = getMid(head);
        Node<Integer> left = mergeSort(head);
        Node<Integer> right = mergeSort(mid);
        return merge(left,right);
    }

    private static Node<Integer> getMid(Node<Integer> head) {
        Node<Integer> temp = null;
        //head will go two steps, temp will go one step.
        while(head!=null && head.next!=null){
            temp = (temp==null) ? head : temp.next;
            head=head.next.next;
        }
        Node<Integer> mid = temp.next;
        temp.next=null;
        return mid;
    }

    private static Node<Integer> merge(Node<Integer> left, Node<Integer> right) {
        Node<Integer> head = new Node<>(null);
        Node<Integer> tail = head; //we need to add at tail because sorting
        while(left!=null && right!=null){
            if(left.data <= right.data){
                tail.next=left;
                left=left.next;
            }else{
                tail.next=right;
                right=right.next;
            }
            tail=tail.next;
        }
        tail.next = (left!=null)?left:right; //if one of them has exhausted
        return head.next;
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(10);
        customLinkedList.add(20);
        customLinkedList.add(2);
        customLinkedList.add(70);
        System.out.println(mergeSort(customLinkedList.head));

    }
}
