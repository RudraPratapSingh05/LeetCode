class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixMap = new HashMap<>();
        prefixMap.put(0,1);
        int currentsum = 0;
        int count = 0;
        for(int num:nums){
            currentsum += num;
            if(prefixMap.containsKey(currentsum - k)){
                count += prefixMap.get(currentsum-k);
            }
            prefixMap.put(currentsum,prefixMap.getOrDefault(currentsum,0)+1);
        }
        return count;
    }
}