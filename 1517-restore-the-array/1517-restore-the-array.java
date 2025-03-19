class Solution {
    public int help(int ind,String s,int k){
        if(ind>=s.length()){
            return 1;
        }
        int count=0;
        for(int i=ind+1;i<=s.length();i++){
            if (s.substring(ind,i).length() >= 1 && s.substring(ind,i).charAt(0) == '0')break;
            if(Integer.parseInt(s.substring(ind,i))<=k){
                count+=help(i,s,k);
            }
            else break;
        }
        return count;
    }
    public int help(String s,int k){
        int dp[]=new int [s.length()+1];
        dp[s.length()]=1;
        for(int ind=dp.length-2;ind>=0;ind--){
             long count=0;
            for(int i=ind+1;i<=s.length();i++){
                if (s.substring(ind,i).length() >= 1 && s.substring(ind,i).charAt(0) == '0')break;
                if(Long.parseLong(s.substring(ind,i))<=k){
                    count=(count+dp[i])%1000000007;
                }
                else break;
            }
            dp[ind]=(int)count;
        }
        return dp[0];

    }
    public int numberOfArrays(String s, int k) {
        // return help(0,s,k);
        return help(s,k);
    }
}