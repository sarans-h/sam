import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        Map<Integer, ArrayList<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }

        int mod = (int) (1e9 + 7);
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] temp = pq.poll();
            int u = (int) temp[0];
            long wt = temp[1];

            if (wt > dist[u]) continue;

            for (int[] nei : graph.get(u)) {
                int v = nei[0];
                long edgeWeight = nei[1];

                if (wt + edgeWeight < dist[v]) {
                    dist[v] = wt + edgeWeight;
                    pq.offer(new long[]{v, dist[v]});
                    ways[v] = ways[u]; 
                } else if (wt + edgeWeight == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }
}
