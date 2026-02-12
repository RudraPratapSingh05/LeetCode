class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        int len=0;
        for(int i=0;i<n;i++){
            int freq[] = new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;

                if(isbal(freq)){
                    len=Math.max(len,j-i+1);
                }
            }
        }
        return len;
    }
    private boolean isbal(int[] freq) {
    int count = 0;

    for (int f : freq) {
        if (f > 0) {
            if (count == 0) {
                count = f;
            } else if (count != f) {
                return false;
            }
        }
    }

    return count > 0;
}

}