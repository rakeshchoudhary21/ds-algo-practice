package Util;

import lombok.Data;

@Data
public class TreeNode<T> {

    private TreeNode(){}

    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T data){
        this.data = data;
        this.left=null;
        this.right=null;
    }

    public String toString(){
        return this.data+"\t left:"+this.left+"\t right:"+this.right;
    }
}
