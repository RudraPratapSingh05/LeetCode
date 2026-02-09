class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        // Use a safe minimum that won't overflow when adding nums[i]
        long INF = (long) 1e17;
        long MIN = -INF;

        long[] dp1 = new long[n]; // Max sum of segment 1 (Increasing)
        long[] dp2 = new long[n]; // Max sum of segment 1 + 2 (Increasing then Decreasing)
        long[] dp3 = new long[n]; // Max sum of segment 1 + 2 + 3 (Inc -> Dec -> Inc)

        for (int i = 0; i < n; i++) {
            dp1[i] = dp2[i] = dp3[i] = MIN;
        }

        // Segment 1 (Strictly Increasing) can start at any index i-1
        // But dp1[i] specifically needs to represent nums[l...p] where l < p
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                // We can start an increasing pair here
                dp1[i] = (long) nums[i - 1] + nums[i];
                // Or extend an existing increasing segment
                if (dp1[i - 1] != MIN) {
                    dp1[i] = Math.max(dp1[i], dp1[i - 1] + nums[i]);
                }

                // Extend the third segment (Final Up)
                if (dp3[i - 1] != MIN) {
                    dp3[i] = Math.max(dp3[i], dp3[i - 1] + nums[i]);
                }
                // Start the third segment from the end of a second segment (Valley q)
                if (dp2[i - 1] != MIN) {
                    dp3[i] = Math.max(dp3[i], dp2[i - 1] + nums[i]);
                }
            }

            if (nums[i] < nums[i - 1]) {
                // Extend the second segment (Decreasing)
                if (dp2[i - 1] != MIN) {
                    dp2[i] = Math.max(dp2[i], dp2[i - 1] + nums[i]);
                }
                // Start the second segment from the end of a first segment (Peak p)
                if (dp1[i - 1] != MIN) {
                    dp2[i] = Math.max(dp2[i], dp1[i - 1] + nums[i]);
                }
            }
        }

        long maxTrionic = MIN;
        for (long val : dp3) {
            maxTrionic = Math.max(maxTrionic, val);
        }

        return maxTrionic;
    }
}