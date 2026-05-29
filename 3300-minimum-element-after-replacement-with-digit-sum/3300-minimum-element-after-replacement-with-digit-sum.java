class Solution {
    public int minElement(int[] nums){
        int[] sums = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int sum=0;
            while(nums[i]>0){
                int dig = nums[i]%10;
                nums[i]/=10;
                sum+=dig;
            }
            sums[i]=sum;
        }
        Arrays.sort(sums);
        return sums[0];
    }
}