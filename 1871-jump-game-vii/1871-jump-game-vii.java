class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n - 1) == '1') return false;
        boolean[] reachable = new boolean[n];
        reachable[0] = true;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        prefix[1] = 1;
        for (int j = 1; j < n; j++) {
            if (s.charAt(j) == '0') {
                int lo = Math.max(0, j - maxJump);
                int hi = j - minJump;
                if (hi >= 0) {
                    int windowSum = prefix[hi + 1] - prefix[lo];
                    if (windowSum > 0) {
                        reachable[j] = true;
                    }
                }
            }
            prefix[j + 1] = prefix[j] + (reachable[j] ? 1 : 0);
        }
        return reachable[n - 1];
    }
}