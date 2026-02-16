class Solution {
    public int reverseBits(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder B = new StringBuilder();
        for(int i=0;i<32-binary.length();i++){
            B.append('0');
        }
        B.append(binary);
        String rev = B.reverse().toString();
        return (int) Long.parseLong(rev,2);
    }
}