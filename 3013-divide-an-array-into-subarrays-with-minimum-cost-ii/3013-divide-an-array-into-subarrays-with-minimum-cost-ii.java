import java.util.*;

class Solution {
    private PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); 
    private PriorityQueue<Integer> right = new PriorityQueue<>(); 
    private Map<Integer, Integer> outdated = new HashMap<>();
    private long currentSum = 0;
    private int leftSize = 0;

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        int m = k - 1;
        left.clear(); right.clear(); outdated.clear();
        currentSum = 0; leftSize = 0;
        for (int i = 1; i <= dist + 1; i++) {
            add(nums[i]);
        }
        balance(m);
        
        long minSum = currentSum;
        for (int i = dist + 2; i < n; i++) {
            remove(nums[i - dist - 1]);
            add(nums[i]);
            balance(m);
            minSum = Math.min(minSum, currentSum);
        }

        return (long) nums[0] + minSum;
    }

    private void add(int val) {
        if (!left.isEmpty() && val <= left.peek()) {
            left.add(val);
            currentSum += val;
            leftSize++;
        } else {
            right.add(val);
        }
    }

    private void remove(int val) {
        outdated.put(val, outdated.getOrDefault(val, 0) + 1);
        if (!left.isEmpty() && val <= left.peek()) {
            currentSum -= val;
            leftSize--;
        }
        clean(left);
        clean(right);
    }

    private void balance(int m) {
        while (leftSize > m) {
            int val = left.poll();
            currentSum -= val;
            leftSize--;
            right.add(val);
            clean(left);
        }
        while (leftSize < m && !right.isEmpty()) {
            int val = right.poll();
            currentSum += val;
            leftSize++;
            left.add(val);
            clean(right);
        }
        clean(left);
        clean(right);
    }
    private void clean(PriorityQueue<Integer> pq) {
        while (!pq.isEmpty() && outdated.getOrDefault(pq.peek(), 0) > 0) {
            int val = pq.poll();
            outdated.put(val, outdated.get(val) - 1);
        }
    }
}