class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int orig = x;
        int y=0;
        while(x!=0){
            int dig=x%10;
            y = (y*10)+dig;
            x=x/10;
        }
        return y==orig;
    }
}