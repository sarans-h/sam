class Solution {
    public int help(int curr ,int prev,int n){
        if(curr==n)return 0;
        if(curr>n)return (int)(1e9);
        int l=2+help(curr*2,curr,n);
        int r=1+help(curr+prev,prev,n);
return Math.min(l,r);

    }
    public int minSteps(int n) {
if(n==1)return 0;
        return 1+ help(1,1,n);
    }
}