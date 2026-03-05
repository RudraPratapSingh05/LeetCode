class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int count0 = 0;
        for(int i=0;i<n;i++){
            char exp;
            if(i%2==0){
                exp = '0';
            }else{
                exp = '1';
            }
            if(s.charAt(i)==exp){
                count0++;
            }
        }
        int count1 = n-count0;
        int count = Math.min(count0,count1);
        return count;
    }
}