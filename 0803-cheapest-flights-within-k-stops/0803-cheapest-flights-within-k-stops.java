class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         // Graph adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
       Queue<int[]>pq=new LinkedList<>();
        pq.offer(new int []{src,0,0});
        int[]dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        while(!pq.isEmpty()){
            int []t=pq.poll();
            int city=t[0];
            int cost=t[1];
            int stops=t[2];
            if(stops>k)continue;
            for(int[]neighbours:graph.getOrDefault(city,new ArrayList<>())){
                int nextCity=neighbours[0];
                int nextCost=neighbours[1]+cost;
                if(nextCost<dist[nextCity]){
                    dist[nextCity]=nextCost;
                    pq.offer(new int []{nextCity,nextCost,stops+1});
                }

            }


        }
       if(dist[dst] == Integer.MAX_VALUE) return -1; 
        return dist[dst]; 
    }
}