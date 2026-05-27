class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       Set<Integer> unique = new HashSet<>();
       for(int num:nums){
        unique.add(num);
       }
       List<Integer> result = new ArrayList<>();
       for(int i=1;i<=nums.length;i++){
        if(!unique.contains(i)){
            result.add(i);
        }
       }
       return result;
}}