class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        long result = 0;
        for(int n:nums){
            if(n==0) count++;
            else count = 0;
            result += count;
        }
        return result;
    }
}