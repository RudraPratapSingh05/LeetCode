class Solution {
    public int concatenatedBinary(int n) {
        long MOD = 1_000_000_007L;
        long total = 0;
        int binaryLength = 0;

        for (int i = 1; i <= n; i++) {
            // ONLY increment length when we hit a new power of 2
            // 1 (2^0), 2 (2^1), 4 (2^2), 8 (2^3)...
            if ((i & (i - 1)) == 0) {
                binaryLength++;
            }
            
            total = ((total << binaryLength) | i) % MOD;
        }

        return (int) total;
    }
}