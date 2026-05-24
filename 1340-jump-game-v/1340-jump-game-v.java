import java.util.HashMap;
import java.util.Map;
class Solution {
    private int[] arr;
    private int d;
    private int n;
    private Map<Integer, Integer> memo;
    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.d = d;
        this.n = arr.length;
        this.memo = new HashMap<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dfs(i));
        }
        return result;
    }
    private int dfs(int i) {
        if (memo.containsKey(i)) return memo.get(i);
        int best = 1;
        for (int x = 1; x <= d; x++) {
            int j = i + x;
            if (j >= n) break;
            if (arr[j] >= arr[i]) break;
            best = Math.max(best, 1 + dfs(j));
        }
        for (int x = 1; x <= d; x++) {
            int j = i - x;
            if (j < 0) break;
            if (arr[j] >= arr[i]) break;
            best = Math.max(best, 1 + dfs(j));
        }
        memo.put(i, best);
        return best;
    }
}