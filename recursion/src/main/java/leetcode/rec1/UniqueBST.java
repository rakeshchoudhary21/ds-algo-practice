package leetcode.rec1;

import Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST {


    /**
     * Catalan number: number of unique bst at i = cartesian product of number of unique tree at j-1 and i-j
     * @param N
     * @return
     */
    public static int numberOfUniqueBST(int N){
        int[] DP = new int[N+1];
        DP[0]=DP[1]=1;
        for(int i=2;i<=N;i++)
            for(int j=1;j<=i;j++)
                DP[i]+= DP[j-1]+DP[i-j];

        return DP[N];
    }

    /**
     * Number of possible BST is actually catalan numbers, to print those trees we can use below approach
     * @param N
     * @return
     */
    public static List<TreeNode> allTrees(int N){
        return allTrees(1,N);
    }

    //Note: how it creates BST? because numbers are already sorted: 1->N
    private static List<TreeNode> allTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if(start>end) {
            allTrees.add(null);
            return allTrees;
        }

        for(int i=start;i<=end;i++){
            List<TreeNode> leftSubTrees = allTrees(start,i-1);
            List<TreeNode> rightSubTrees = allTrees(i+1,end);

            for(TreeNode lNode: leftSubTrees){
                for(TreeNode rNode: rightSubTrees){
                    TreeNode<Integer> node = new TreeNode<>(i);
                    node.setLeft(lNode);
                    node.setRight(rNode);
                    allTrees.add(node);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args) {
        System.out.println(allTrees(2));
        System.out.println(numberOfUniqueBST(2));
    }
}
