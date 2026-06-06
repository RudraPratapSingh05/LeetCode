class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] diff = new int[nums.length];
        int left = 0;
        int right =0;
        for(int i=0;i<nums.length;i++){
            right += nums[i];
        }
        for(int i=0;i<nums.length;i++){
            right -= nums[i];
            diff[i] = Math.abs(right-left);
            left += nums[i];
        }
        return diff;
    }
}