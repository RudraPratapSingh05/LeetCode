class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n+1];
        bits[0]=0;
        for(int i=1;i<bits.length;i++){
            int count = 0;
            int curr = i;
            while(curr>0){
                int bit = curr%2;
                if(bit==1) count++;
                curr = curr/2;
            }
            bits[i] = count;
        }
        return bits;
    }
}