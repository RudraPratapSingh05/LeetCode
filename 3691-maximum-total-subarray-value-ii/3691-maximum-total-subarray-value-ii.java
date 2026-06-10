class Solution {
    private int[][] sparseMax, sparseMin;
    private int[] log2;

    private void buildSparseTable(int[] nums) {
        int n = nums.length;
        int LOG = 32 - Integer.numberOfLeadingZeros(n);

        sparseMax = new int[LOG][n];
        sparseMin = new int[LOG][n];
        log2 = new int[n + 1];

        log2[1] = 0;
        for (int i = 2; i <= n; i++) {
            log2[i] = log2[i / 2] + 1;
        }

        sparseMax[0] = nums.clone();
        sparseMin[0] = nums.clone();

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                sparseMax[j][i] = Math.max(sparseMax[j-1][i], sparseMax[j-1][i + (1 << (j-1))]);
                sparseMin[j][i] = Math.min(sparseMin[j-1][i], sparseMin[j-1][i + (1 << (j-1))]);
            }
        }
    }

    private int queryMax(int l, int r) {
        int k = log2[r - l + 1];
        return Math.max(sparseMax[k][l], sparseMax[k][r - (1 << k) + 1]);
    }

    private int queryMin(int l, int r) {
        int k = log2[r - l + 1];
        return Math.min(sparseMin[k][l], sparseMin[k][r - (1 << k) + 1]);
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        buildSparseTable(nums);

        PriorityQueue<long[]> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        Set<Long> visited = new HashSet<>();

        for (int r = 1; r < n; r++) {
            long enc = (long) 0 * (n + 1) + r;
            if (visited.add(enc)) {
                maxHeap.offer(new long[]{queryMax(0, r) - queryMin(0, r), 0, r});
            }
        }
        for (int l = 0; l < n - 1; l++) {
            long enc = (long) l * (n + 1) + (n - 1);
            if (visited.add(enc)) {
                maxHeap.offer(new long[]{queryMax(l, n - 1) - queryMin(l, n - 1), l, n - 1});
            }
        }

        long total = 0;

        while (k-- > 0 && !maxHeap.isEmpty()) {
            long[] top = maxHeap.poll();
            long val = top[0];
            int l = (int) top[1];
            int r = (int) top[2];

            total += val;

            if (l + 1 < r) {
                long enc = (long) (l + 1) * (n + 1) + r;
                if (visited.add(enc)) {
                    maxHeap.offer(new long[]{queryMax(l + 1, r) - queryMin(l + 1, r), l + 1, r});
                }
            }

            if (l < r - 1) {
                long enc = (long) l * (n + 1) + (r - 1);
                if (visited.add(enc)) {
                    maxHeap.offer(new long[]{queryMax(l, r - 1) - queryMin(l, r - 1), l, r - 1});
                }
            }
        }

        return total;
    }
}