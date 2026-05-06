import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store: Value -> Index
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = target - current;
            
            // If the "missing piece" is in the map, we are done!
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, store this number so a future number can find it
            map.put(current, i);
        }
        
        // The problem guarantees a solution, so we don't need a fallback
        return new int[] {};
    }
}