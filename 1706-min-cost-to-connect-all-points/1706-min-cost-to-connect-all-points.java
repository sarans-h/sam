class Solution {
    public int distance(int i,int j,int points[][]){
        return Math.abs(points[i][1]-points[j][1])+Math.abs(points[i][0]-points[j][0]);
    }
    public int minCostConnectPoints(int[][] points) {
        HashSet<Integer>visited=new HashSet<>();
        int sum=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int temp[]=pq.poll();
            int wt=temp[0];
            int node=temp[1];
            if(visited.contains(node))continue;
            visited.add(node);
            sum+=wt;

            for(int i=0;i<points.length;i++){
                if(!visited.contains(i)){
                    pq.offer(new int[]{distance(node,i,points),i});
                }
            }
        }
        return sum;
    }
}