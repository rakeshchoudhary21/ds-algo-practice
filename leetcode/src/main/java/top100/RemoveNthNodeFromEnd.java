package top100;

import Util.Node;

public class RemoveNthNodeFromEnd {
    //Nth node from end is Size()-Nth node from begining.

    public Node<Integer> removeNthFromEnd(Node<Integer> head, int n) {
        int size = getSize(head);
        n=size-n;
        if(n==0){
            head=head.next;
            return head;
        }

        //remaining cases
        int i=0;
        Node<Integer> t = head;
        while(t!=null){
            if(i+1 == n){
                t.next=t.next.next;
                break;
            }

            t=t.next;
            i++;
        }

        return head;
    }

    private int getSize(Node<Integer> head){
        Node<Integer> t = head;
        int x=0;
        while(t!=null){
            x+=1;
            t=t.next;
        }
        return x;
    }

    public static void main(String[] args) {

    }
}
