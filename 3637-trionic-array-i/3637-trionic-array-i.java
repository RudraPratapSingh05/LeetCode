class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false;
        for (int p = 1; p < n - 1; p++) {
            for (int q = p + 1; q < n - 1; q++) {
                if (checknums(nums, p, q)) return true;
            }
        }
        return false;
    }

    private boolean checknums(int[] nums, int p, int q) {
        for (int i = 0; i < p; i++) {
            if (nums[i] >= nums[i + 1]) return false;
        }
        for (int i = p; i < q; i++) {
            if (nums[i] <= nums[i + 1]) return false;
        }
        for (int i = q; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) return false;
        }

        return true;
    }
}