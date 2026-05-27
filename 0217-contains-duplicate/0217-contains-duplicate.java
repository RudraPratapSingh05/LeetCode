class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> orig = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            orig.add(nums[i]);
        }
        if(orig.size()==nums.length) return false;
        else return true;
    }
}