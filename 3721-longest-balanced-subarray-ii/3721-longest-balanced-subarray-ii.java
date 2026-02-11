import java.util.*;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        // Segment Tree to store the 'balance' value for each starting position L
        // We need to find the leftmost index where balance == 0
        int[] tree = new int[4 * n];
        int[] lazy = new int[4 * n];
        int[] minVal = new int[4 * n];
        int[] maxVal = new int[4 * n];
        
        int maxLen = 0;
        Map<Integer, Integer> lastSeen = new HashMap<>();
        
        for (int r = 0; r < n; r++) {
            int val = nums[r];
            int prev = lastSeen.getOrDefault(val, -1);
            
            // If even, add 1 to balance for all L in (prev, r]
            // If odd, subtract 1 from balance for all L in (prev, r]
            int delta = (val % 2 == 0) ? 1 : -1;
            update(1, 0, n - 1, prev + 1, r, delta, tree, lazy, minVal, maxVal);
            
            // Find the leftmost L in [0, r] where the balance is 0
            int leftmostL = findLeftmostZero(1, 0, n - 1, 0, r, tree, lazy, minVal, maxVal);
            
            if (leftmostL != -1) {
                maxLen = Math.max(maxLen, r - leftmostL + 1);
            }
            
            lastSeen.put(val, r);
        }
        
        return maxLen;
    }

    private void pushDown(int node, int[] lazy, int[] minVal, int[] maxVal) {
        if (lazy[node] != 0) {
            lazy[2 * node] += lazy[node];
            minVal[2 * node] += lazy[node];
            maxVal[2 * node] += lazy[node];
            
            lazy[2 * node + 1] += lazy[node];
            minVal[2 * node + 1] += lazy[node];
            maxVal[2 * node + 1] += lazy[node];
            
            lazy[node] = 0;
        }
    }

    private void update(int node, int start, int end, int l, int r, int delta, 
                        int[] tree, int[] lazy, int[] minVal, int[] maxVal) {
        if (start > end || start > r || end < l) return;
        if (start >= l && end <= r) {
            lazy[node] += delta;
            minVal[node] += delta;
            maxVal[node] += delta;
            return;
        }
        pushDown(node, lazy, minVal, maxVal);
        int mid = (start + end) / 2;
        update(2 * node, start, mid, l, r, delta, tree, lazy, minVal, maxVal);
        update(2 * node + 1, mid + 1, end, l, r, delta, tree, lazy, minVal, maxVal);
        minVal[node] = Math.min(minVal[2 * node], minVal[2 * node + 1]);
        maxVal[node] = Math.max(maxVal[2 * node], maxVal[2 * node + 1]);
    }

    private int findLeftmostZero(int node, int start, int end, int l, int r, 
                                 int[] tree, int[] lazy, int[] minVal, int[] maxVal) {
        if (start > end || start > r || end < l || minVal[node] > 0 || maxVal[node] < 0) {
            return -1;
        }
        if (start == end) return start;
        
        pushDown(node, lazy, minVal, maxVal);
        int mid = (start + end) / 2;
        
        // Always try the left child first to get the "Longest" subarray
        int res = findLeftmostZero(2 * node, start, mid, l, r, tree, lazy, minVal, maxVal);
        if (res == -1) {
            res = findLeftmostZero(2 * node + 1, mid + 1, end, l, r, tree, lazy, minVal, maxVal);
        }
        return res;
    }
}