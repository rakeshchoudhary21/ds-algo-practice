package top100;

import Util.Node;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public Node<Integer> mergeKLists(Node<Integer>[] lists) {
        PriorityQueue<Node<Integer>> pq = new PriorityQueue<>((i1, i2) -> i2.data-i1.data);

        for(Node l: lists){
            while(l!=null){
                pq.offer(l);
                l=l.next;
            }
        }

        Node<Integer> res=null;
        while(pq.isEmpty()==false){
            Node<Integer> t = pq.poll();
            t.next=null;
            if(res==null) res=t;
            else{
                t.next=res;
                res=t;
            }
        }
        return res;

    }
}
