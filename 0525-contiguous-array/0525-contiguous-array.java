import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int length = 0;
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // base case: sum 0 seen at index -1

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                sum -= 1;
            } else {
                sum += 1;
            }

            if (map.containsKey(sum)) {
                length = Math.max(length, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return length;
    }
}