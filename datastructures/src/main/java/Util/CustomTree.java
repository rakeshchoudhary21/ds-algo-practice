package Util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomTree<T> {

    public TreeNode<T> constructBinaryTree(T[] arr){
        return constructBinaryTree(arr,0);
    }

    private TreeNode<T> constructBinaryTree(T[] arr,int curr){
        if(curr>arr.length-1) return null;
        TreeNode<T> root = new TreeNode<>(arr[curr]);
        root.setLeft(constructBinaryTree(arr,curr*2+1));
        root.setRight(constructBinaryTree(arr,curr*2+2));
        return root;
    }

    public void displayTreeInOrder(TreeNode<T> root){
        if(root==null) return;
        displayTreeInOrder(root.getLeft());
        log.info("Node Value:{}",root.getData());
        displayTreeInOrder(root.getRight());
    }

    public static void main(String[] args) {
        CustomTree<Integer> customTree = new CustomTree<>();
        Integer[] arr = {1,2,3,4,5,6};
        TreeNode<Integer> root = customTree.constructBinaryTree(arr);
        customTree.displayTreeInOrder(root);
    }
}
