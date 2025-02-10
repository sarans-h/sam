class Solution {
    public double help(double x,long n){
        if(n==0)return 1;
        if(n<0){
            return help(1/x,-n);
        }
        if(n%2==0)return help(x*x,n/2);
        return x*help(x,n-1);
    }
    public double myPow(double x, int n) {
        return help(x,(long)n);
    }
}