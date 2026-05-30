class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] sortedSq = new int[nums.length];
        int right = nums.length-1;
        int left = 0;
        for(int i=nums.length-1;i>=0;i--){
            if(Math.abs(nums[right])>Math.abs(nums[left])){
                sortedSq[i]=nums[right]*nums[right];
                right--;
            }
            else{
                sortedSq[i]=nums[left]*nums[left];
                left++;
            }
        }
        return sortedSq;
    }
}