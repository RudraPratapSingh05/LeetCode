class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right=nums.length-1;
        int maxsum=0;

        while(left<right){
            maxsum=Math.max(maxsum,nums[left]+nums[right]);
            left++;
            right--;
        }
        return maxsum;
    }
}