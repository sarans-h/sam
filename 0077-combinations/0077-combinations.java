class Solution {
    List<List<Integer>>res=new ArrayList<>();
    public void help(int n,int curr,int k,ArrayList<Integer>al){
        if(al.size()==k){
            res.add(new ArrayList<>(al));
            return ;
        }
        for(int i=curr;i<=n;i++){
            al.add(i);
            help(n,i+1,k,al);
            al.remove(al.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        help(n,1,k,new ArrayList<>());
        return res;
    }
}