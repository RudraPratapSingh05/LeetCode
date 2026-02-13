import java.util.*;

class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<String> seenGroups = new HashSet<>();
        long start = (long) Math.pow(10, (n + 1) / 2 - 1);
        long end = (long) Math.pow(10, (n + 1) / 2);

        // 1. Generate only n-digit palindromes
        for (long i = start; i < end; i++) {
            String s = Long.toString(i);
            String full = s + new StringBuilder(s.substring(0, n / 2)).reverse().toString();
            if (Long.parseLong(full) % k == 0) {
                char[] chars = full.toCharArray();
                Arrays.sort(chars);
                seenGroups.add(new String(chars));
            }
        }

        long totalGood = 0;
        for (String group : seenGroups) {
            totalGood += calculateWays(group, n);
        }
        return totalGood;
    }

    private long calculateWays(String group, int n) {
        int[] freq = new int[10];
        for (char c : group.toCharArray()) freq[c - '0']++;

        // Total permutations = n! / (f0! * f1! * ... * f9!)
        long count = factorial(n);
        for (int f : freq) count /= factorial(f);

        // Subtract cases where a '0' is at the front
        if (freq[0] > 0) {
            long leadingZeros = factorial(n - 1);
            freq[0]--; // Imagine one '0' is fixed at the start
            for (int f : freq) leadingZeros /= factorial(f);
            count -= leadingZeros;
        }
        return count;
    }

    private long factorial(int num) {
        long res = 1;
        for (int i = 2; i <= num; i++) res *= i;
        return res;
    }
}