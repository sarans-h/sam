class Solution {
    public int help(int current,int previous,int n){
        if(current == n)return 0;
        if(current > n)return (int)1e9;
        int pastingprev=1+help(current+previous,previous,n);
        int copingAndPastingCurrert=2+help(current*2,current,n);
        return Math.min(pastingprev,copingAndPastingCurrert);
    }
    public int minSteps(int n) {
        if(n==1)return 0;
        return 1+help(1,1,n);
    }
}