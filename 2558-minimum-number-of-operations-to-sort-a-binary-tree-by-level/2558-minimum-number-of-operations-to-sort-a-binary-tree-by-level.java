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
    public void swap(ArrayList<Integer> al, int i, int j) {
        int temp = al.get(i);
        al.set(i, al.get(j));
        al.set(j, temp);
    }
    public int count(ArrayList<Integer>al){
        int cou=0;
        ArrayList<Integer>copy=new ArrayList<>(al);
        Collections.sort(copy);
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<al.size();i++){
            map.put(al.get(i),i);
        }
        for(int i=0;i<al.size();i++){
            if(al.get(i)==copy.get(i)){
                continue;
            }
            int currInd=map.get(copy.get(i));
            map.put(al.get(i),currInd);
            swap(al,currInd,i);
            cou++;

        }
        return cou;

        
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        int swap=0;
        q.offer(root);
        while(!q.isEmpty()){
            int n=q.size();
            ArrayList<Integer>al=new ArrayList<>();
            while(n-->0){
                TreeNode temp=q.poll();
                al.add(temp.val);
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
            swap+=(count(al));

        }
        return swap;
    }
}