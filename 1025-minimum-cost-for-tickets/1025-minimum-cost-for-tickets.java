class Solution {
    int dp[];
    public boolean can(int days[],int run){
        return Arrays.binarySearch(days, run) >= 0;
    }
    public int help(int run,int days[],int []costs){
        if(run>days[days.length-1])return 0;
        if(dp[run]!=-1)return dp[run];
        if(can(days,run)){
            int one=costs[0]+help(run+1,days,costs);
            int seven=costs[1]+help(run+7,days,costs);
            int trty=costs[2]+help(run+30,days,costs);
            return dp[run]= Math.min(one,Math.min(seven,trty));
        }
        return dp[run]=help(run+1,days,costs);
    }
    public int mincostTickets(int[] days, int[] costs) {
        dp=new int [days[days.length-1]+1];
        Arrays.fill(dp,-1);
        return help(1,days,costs);
    }
}