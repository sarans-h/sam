
class Solution {
    int[] parent;
    int[] rank;

    // Find with path compression
    public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // Union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        parent = new int[n];
        rank = new int[n];

        // Initialize Union-Find
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        // Pair numbers with their indices and sort
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

        // Union adjacent elements in the sorted array if |nums[i] - nums[j]| <= limit
        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(pairs[i][0] - pairs[i + 1][0]) <= limit) {
                union(pairs[i][1], pairs[i + 1][1]);
            }
        }

        // Group elements by their root
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            groupMap.putIfAbsent(root, new ArrayList<>());
            groupMap.get(root).add(nums[i]);
        }

        // Sort each group
        for (List<Integer> group : groupMap.values()) {
            Collections.sort(group);
        }

        // Build the result array
        int[] result = new int[n];
        Map<Integer, Integer> groupIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            int idx = groupIndex.getOrDefault(root, 0);
            result[i] = groupMap.get(root).get(idx);
            groupIndex.put(root, idx + 1);
        }

        return result;
}
}