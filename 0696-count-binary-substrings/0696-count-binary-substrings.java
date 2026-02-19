class Solution {
    public int countBinarySubstrings(String s) {
       int ans = 0;
       int prevlen = 0;
       int nextlen = 1;
       for(int i=1;i<s.length();i++){
        if(s.charAt(i)==s.charAt(i-1)){
            nextlen++;
        }else{
            ans+=Math.min(prevlen,nextlen);
            prevlen = nextlen;
            nextlen=1;
        }
       }
    return ans+Math.min(prevlen,nextlen);
    }
}