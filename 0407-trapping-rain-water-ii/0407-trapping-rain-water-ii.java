class Solution {
    public int trapRainWater(int[][] nums) {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->(a[0]-b[0]));
         boolean  vis[][]=new boolean [nums.length][nums[0].length];

        for(int i=0;i<nums[0].length;i++){
            pq.offer(new int []{nums[0][i],0,i});
            vis[0][i]=true;
            pq.offer(new int[]{nums[nums.length-1][i],nums.length-1,i});
            vis[nums.length-1][i]=true;
        }
        
        for(int i=0;i<nums.length;i++){
            pq.offer(new int []{nums[i][0],i,0});
            vis[i][0]=true;
            pq.offer(new int[]{nums[i][nums[0].length-1],i,nums[0].length-1});
            vis[i][nums[0].length-1]=true;
        }
        int [][]directions=new int[][]{{0,-1},{-1,0},{1,0},{0,1}};
       int water=0;

        while(!pq.isEmpty()){
            int t[]=pq.poll();
            int ch=t[0];
            int cx=t[1];
            int cy=t[2];
            for(int dir[]:directions){
                int newx=dir[0]+cx;
                int newy=dir[1]+cy;
                if(newx>=0&&newy>=0&&newx<nums.length&&newy<nums[0].length&&!vis[newx][newy]){
water+=(Math.max(ch-nums[newx][newy],0));
vis[newx][newy]=true;
pq.offer(new int[]{Math.max(ch,nums[newx][newy]),newx,newy});
                }

            }

        }
            return water;


    }
}