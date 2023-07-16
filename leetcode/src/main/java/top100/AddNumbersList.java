package top100;

import Util.CustomLinkedList;
import Util.Node;

public class AddNumbersList {


    //Iterative approach
    public static Node<Integer> iterative(Node<Integer> head1,Node<Integer> head2){
        Node<Integer> res = null;
        int carry=0;
        while (head1!=null || head2!=null){
            int n1 = (head1!=null) ? head1.data: 0;
            int n2 = (head2!=null) ? head2.data: 0;
            int sum = n1+n2+carry;
            Node<Integer> temp = new Node<>(sum%10);
            carry = sum/10;
            temp.next=res;
            res=temp;
            if(head1!=null) head1=head1.next;
            if(head2!=null) head2=head2.next;
        }
        if(carry!=0){
            Node<Integer> c = new Node<>(carry);
            c.next=res;
            res=c;
        }

        return res;
    }

    /**
     * Recursive solution.
     */
    static Node<Integer> res = null;
    public static Node<Integer> addLists(Node<Integer> head1,Node<Integer> head2,int carry){
        if(head1==null && head2==null){
            if(carry>0){
                Node<Integer> c = new Node<>(carry);
                c.next=res;
                res=c;
            }
            return null;
        }
        else {
            int n1 = (head1!=null) ? head1.data: 0;
            int n2 = (head2!=null) ? head2.data: 0;
            int sum = n1+n2+carry;
            Node<Integer> temp = new Node<>(sum%10);
            carry = sum/10;
            temp.next=res;
            res=temp;
            return addLists(head1!=null?head1.next:null,head2!=null?head2.next:null,carry);
        }
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> custom = new CustomLinkedList<>();
        custom.add(2);
        custom.add(4);
        custom.add(3);
        custom.add(5);

        CustomLinkedList<Integer> custom2 = new CustomLinkedList<>();
        custom2.add(9);
        custom2.add(6);
        custom2.add(8);

        addLists(custom.head,custom2.head,0);
        System.out.println(res);


        System.out.println(iterative(custom.head,custom2.head));

        System.out.println("leetcode".substring(0,4));
    }

}
