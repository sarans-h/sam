import java.util.*;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Initialize the adjacency list
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            // Check if adding this edge creates a cycle
            if (hasCycleBFS(graph, u, v)) {
                return edge; // Found the redundant edge
            }

            // Otherwise, add the edge to the graph
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return new int[0]; // Should never reach here
    }

    private boolean hasCycleBFS(Map<Integer, List<Integer>> graph, int src, int dest) {
        if (!graph.containsKey(src) || !graph.containsKey(dest)) return false;

        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new int[]{src, -1}); // {node, parent}

        while (!queue.isEmpty()) {
            int[] nodeInfo = queue.poll();
            int node = nodeInfo[0], parent = nodeInfo[1];

            if (node == dest) return true; // Cycle detected

            visited.add(node);
            for (int neighbor : graph.get(node)) {
                if (neighbor == parent) continue; // Ignore the parent node
                if (visited.contains(neighbor)) return true; // Found a cycle
                queue.offer(new int[]{neighbor, node});
            }
        }
        return false;
    }
}
