class Solution {
    // LeetCode expects the method name to be "findKthBit" 
    // but your error shows you named it "findKthBitIterative"
    public char findKthBit(int n, int k) {
        int flipCount = 0;
        
        while (n > 1) {
            // Using the bitwise trick we discussed!
            int length = (1 << n) - 1;
            int mid = (length / 2) + 1;
            
            if (k == mid) {
                // If it's the middle bit, it's always '1', 
                // but we must account for how many times it was flipped
                return (flipCount % 2 == 0) ? '1' : '0';
            } else if (k > mid) {
                // Mirror the position to the first half
                k = length - k + 1;
                // Increment flip because the second half is inverted
                flipCount++;
            }
            // Move down to the previous string sequence
            n--;
        }
        
        // Base case: S1 is '0'. Flip it based on flipCount.
        return (flipCount % 2 == 0) ? '0' : '1';
    }
}