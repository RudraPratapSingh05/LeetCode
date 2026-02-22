class Solution {
    public int binaryGap(int n) {
        int maxdist=0;
        int lastpos = -1;
        int currpos=0;
        while(n>0){
            if((n&1)==1){
                if(lastpos!=-1){
                    maxdist = Math.max(maxdist,currpos-lastpos);
                }
                lastpos=currpos;
            }
            n>>=1;
            currpos++;
        }
        return maxdist;
    }
}