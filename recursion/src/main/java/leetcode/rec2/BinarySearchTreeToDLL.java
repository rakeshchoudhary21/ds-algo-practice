package leetcode.rec2;

import Util.TreeNode;

public class BinarySearchTreeToDLL {

    TreeNode<Integer> last;
    TreeNode<Integer> first;
    public TreeNode<Integer> treeToDoublyList(TreeNode<Integer> root) {
        if(root==null) return null;

        buildList(root);
        last.setRight(first);
        first.setLeft(last);
        return first;
    }

    private void buildList(TreeNode<Integer> root){
        if(root!=null){
            buildList(root.getLeft());
            if(last!=null){
                last.setRight(root);
                root.setLeft(last);
            }else first=root;

            last=root;
            buildList(root.getRight());
        }
    }

}
