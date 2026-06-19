class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int count=1;
        int curr = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]) continue;
            if(nums[i]-nums[i-1]==1) curr++;
            else{
                count = Math.max(count,curr);
                curr=1;
            }
        }
        return Math.max(curr,count);
    }
}