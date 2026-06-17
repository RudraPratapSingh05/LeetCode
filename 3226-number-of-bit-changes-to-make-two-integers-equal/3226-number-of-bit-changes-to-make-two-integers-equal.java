class Solution {
    public int minChanges(int n, int k) {
        if((n&k)!=k) return -1;
        int xor = (n^k);
        int result = Integer.bitCount(xor);
        return result;
    }
}