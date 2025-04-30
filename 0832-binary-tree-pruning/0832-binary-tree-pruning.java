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
        public boolean isOnePresent(TreeNode root) {
        if (root == null) return false;
        return root.val == 1 || isOnePresent(root.left) || isOnePresent(root.right);
    }
    public TreeNode help(TreeNode root){
        if(root==null)return null;
        if(!isOnePresent(root.left))root.left=null;
        else root.left=help(root.left);
        if(!isOnePresent(root.right))root.right=null;
        else root.right=help(root.right);
        if(root.left==null&&root.right==null&&root.val==0)
        return null; 
        return root;
    }
    public TreeNode pruneTree(TreeNode root) {
        return help(root);
    }
}