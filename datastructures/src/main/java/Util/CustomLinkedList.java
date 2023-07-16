package Util;


import lombok.Data;

@Data
public class CustomLinkedList<T> {

    public Node<T> head;

    public void add(T data) {
        if(head==null){
            head= new Node<>(data);
        }else{
            Node<T> temp = new Node<>(data);
            temp.next=head;
            head=temp;
        }
    }

    public boolean remove(){
        if(head==null) return false;
        head=head.next;
        return true;
    }

    public void display(){
        Node<T> temp = head;
        while(temp!=null) {
            System.out.print(temp.data);
            temp=temp.next;
            if(temp!=null) System.out.print("->");
            else System.out.println();

        }
    }
}
