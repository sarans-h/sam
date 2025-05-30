class Solution {
    public int help(int ind1,int ind2,String s1,String s2){
        if(ind1<0||ind2<0)return 0;
        if(s1.charAt(ind1)==s2.charAt(ind2))return 1+help(ind1-1,ind2-1,s1,s2);
        return Math.max(help(ind1-1,ind2,s1,s2),help(ind1,ind2-1,s1,s2));
    }
    // public int help(int ind1,int ind2,String s1,String s2){
    //     if(ind1==0||ind2==0)return 0;
    //     if(s1.charAt(ind1-1)==s2.charAt(ind2-1))return 1+help(ind1-1,ind2-1,s1,s2);
    //     return Math.max(help(ind1-1,ind2,s1,s2),help(ind1,ind2-1,s1,s2));
    // }shifted a index back 0 as negative 1 as 0 n +1 as n
    public int helpmemo(int ind1,int ind2,String s1,String s2,int dp[][]){
        if(ind1<0||ind2<0)return 0;
        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2))return 1+ helpmemo(ind1-1,ind2-1,s1,s2,dp);
        return dp[ind1][ind2]=Math.max( helpmemo(ind1-1,ind2,s1,s2,dp), helpmemo(ind1,ind2-1,s1,s2,dp));
    }
    public int tabu(String s1,String s2){
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        for(int j=0;j<=s2.length();j++)dp[0][j]=0;
        for(int i=0;i<=s1.length();i++)dp[i][0]=0;
        for(int ind1=1;ind1<=s1.length();ind1++){
            for(int ind2=1;ind2<=s2.length();ind2++){
                if(s1.charAt(ind1-1)==s2.charAt(ind2-1))
                dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                else 
                dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
            }
        }
        return dp[s1.length()][s2.length()];

    }
    public int longestCommonSubsequence(String s1, String s2) {
//      int dp[][]=new int [s1.length()][s2.length()];
//      for(int i[]:dp) {
// Arrays.fill(i,-1);
//      }
//      return helpmemo(s1.length()-1,s2.length()-1,s1,s2,dp);   
        return tabu(s1,s2);
    }
}