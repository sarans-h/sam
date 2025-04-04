/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 // Custom Pair class
class Pair<U, V> {
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public  Pair<TreeNode, Integer> help(TreeNode root){
        if(root==null)return new Pair<>(null,0);
        Pair<TreeNode,Integer>l=help(root.left);
        Pair<TreeNode,Integer>r=help(root.right);
        if(l.second<r.second)return new Pair<>(r.first,r.second+1);
        if(r.second<l.second)return new Pair<>(l.first,l.second+1);
        return new Pair<>(root,r.second+1);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return help(root).first;       
    }
}