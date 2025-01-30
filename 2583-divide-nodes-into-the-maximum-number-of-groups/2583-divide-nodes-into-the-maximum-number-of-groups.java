import java.util.*;

public class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        
        // Build adjacency list
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] color = new int[n + 1]; // 0: unvisited, 1 & -1: two colors
        Arrays.fill(color, 0);

        int maxGroups = 0;

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                List<Integer> component = new ArrayList<>();
                if (!isBipartite(graph, i, color, component)) {
                    return -1; // If not bipartite, return -1
                }
                maxGroups += getMaxDepth(graph, component);
            }
        }
        return maxGroups;
    }

    private boolean isBipartite(List<Integer>[] graph, int start, int[] color, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1;
        component.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == 0) {
                    color[neighbor] = -color[node]; // Alternate color
                    queue.offer(neighbor);
                    component.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false; // Odd cycle detected, not bipartite
                }
            }
        }
        return true;
    }

    private int getMaxDepth(List<Integer>[] graph, List<Integer> component) {
        int maxDepth = 0;
        for (int node : component) {
            maxDepth = Math.max(maxDepth, bfsMaxDepth(graph, node));
        }
        return maxDepth;
    }

    private int bfsMaxDepth(List<Integer>[] graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> depth = new HashMap<>();
        queue.offer(start);
        depth.put(start, 1);

        int maxDepth = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (!depth.containsKey(neighbor)) {
                    depth.put(neighbor, depth.get(node) + 1);
                    queue.offer(neighbor);
                    maxDepth = Math.max(maxDepth, depth.get(neighbor));
                }
            }
        }
        return maxDepth;
    }
}
