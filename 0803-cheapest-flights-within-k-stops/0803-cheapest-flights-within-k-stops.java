class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
     int dist[]=new int[n];
    Arrays.fill(dist,Integer.MAX_VALUE);
    dist[src]=0;
    PriorityQueue<int []>pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
    pq.offer(new int []{src,0,0});
    while(!pq.isEmpty()){
        int t[]=pq.poll();
        int city=t[0];
        int cost=t[1];
        int stops=t[2];
        if(stops>k)continue;
        for(int neighbour[]:graph.getOrDefault(city,new ArrayList<>())){
            int newCity=neighbour[0];
            int newCost=neighbour[1]+cost;

            if(newCost<dist[newCity]){
                dist[newCity]=newCost;
                pq.offer(new int[]{newCity,newCost,stops+1});
            }
        }
    }
    return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}