class Solution {
    public boolean help(int ind1,int ind2,String s1,String s2,String s3,int dp[][]){
        if(ind1+ind2==s3.length())return true;
        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2]==1;
        boolean ans=false;
        if(ind1<s1.length()&&s1.charAt(ind1)==s3.charAt(ind1+ind2)){
            ans|=help(ind1+1,ind2,s1,s2,s3,dp);
        }
        if(ind2<s2.length()&&s2.charAt(ind2)==s3.charAt(ind1+ind2)){
            ans|=help(ind1,ind2+1,s1,s2,s3,dp);
        }
        dp[ind1][ind2]=ans?1:0;
        return ans;

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())return false;
        int dp[][]=new int [s1.length()+1][s2.length()+1];
        for(int i[]:dp)Arrays.fill(i,-1);
        return help(0,0,s1,s2,s3,dp);
    }
}