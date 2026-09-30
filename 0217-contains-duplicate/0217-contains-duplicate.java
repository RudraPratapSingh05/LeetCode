class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> dupe = new HashSet<>();
        for(int num:nums){
            if(dupe.contains(num)) return true;
            dupe.add(num);
        }
        return false;
    }
}