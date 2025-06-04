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
class Solution {
    public int help(TreeNode root){
        if(root==null)return 0;
        int left=hei(root.left);
        int right=hei(root.right);
        int d=2+left+right;
        return Math.max(left,Math.max(right,d));
    }
    int hei(TreeNode root){
        if(root==null)return -1;
        int l=hei(root.left);
        int r=hei(root.right);
        return Math.max(l,r)+1;
    }
    int d=0;
    public int dia(TreeNode root){
        if(root==null)return 0;
        int l=dia(root.left);
        int r=dia(root.right);
        d=Math.max(d,l+r);
        return Math.max(l,r)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        // return help(root);
        dia(root);
        return d;
    }
}