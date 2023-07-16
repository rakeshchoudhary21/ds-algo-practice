package leetcode.rec1;

import Util.CustomTree;
import Util.TreeNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TreeDepth {

    static int depth(TreeNode<Integer> root){
        if(root==null) return 0;
        return 1+Math.max(depth(root.getLeft()),depth(root.getRight()));
    }

    public static void main(String[] args) {
        CustomTree<Integer> tree = new CustomTree<>();
        Integer[] arr = {3,9,20,null,null,15,7};
        TreeNode<Integer> root = tree.constructBinaryTree(arr);
        tree.displayTreeInOrder(root);
        log.info("depth is={}",depth(root));
    }
}
