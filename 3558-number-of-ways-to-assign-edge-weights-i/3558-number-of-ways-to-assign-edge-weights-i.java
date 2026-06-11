class Solution {
    private static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // BFS to find max depth
        int maxDepth = 0;
        int[] depth = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;
        depth[1] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            maxDepth = Math.max(maxDepth, depth[node]);
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    depth[neighbor] = depth[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        // Answer is 2^(maxDepth - 1)
        return power(2, maxDepth - 1);
    }

    private int power(long base, int exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return (int) result;
    }
}