class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> dupes = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(dupes.containsKey(nums[i]) && i-dupes.get(nums[i])<=k){
                return true;
            }
            dupes.put(nums[i],i);
        }
        return false;
    }
}