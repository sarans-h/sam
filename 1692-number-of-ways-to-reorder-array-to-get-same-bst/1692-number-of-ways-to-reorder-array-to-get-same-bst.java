class Solution {
     final int MOD = 1_000_000_007;
    ArrayList<ArrayList<Integer>>pascal;
    public long help(ArrayList<Integer>al){
         if (al.size() <= 1) return 1;
        ArrayList<Integer>left=new ArrayList<>();
        ArrayList<Integer>right=new ArrayList<>();
        int root=al.get(0);
        for(int i:al){
            if(i<root)left.add(i);
            if(i>root)right.add(i);

        }
        long lans=help(left)%MOD;
        long rans=help(right)%MOD;
        
        return (pascal.get(al.size()-1).get(left.size())*lans%MOD*rans%MOD)%MOD;


    }
    public int numOfWays(int[] nums) {
        pascal=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            pascal.add(new ArrayList<>(Collections.nCopies(i+1,1)));
            for(int j=1;j<i;j++){
                pascal.get(i).set(j,(pascal.get(i-1).get(j-1)+pascal.get(i-1).get(j))%MOD);

            }
        }
        ArrayList<Integer>al=new ArrayList<>();
        for(int i:nums){
            al.add(i);
        }
        return (int)((help(al)-1+MOD)%MOD);


    }
}