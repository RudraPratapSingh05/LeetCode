class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;
        for(int n=num1;n<=num2;n++){
            total += waviness(n);
        }
        return total;
    }
    public int waviness(int n){
        String s = Integer.toString(n);
        int len = s.length();
        if(len<3) return 0;
        int count = 0;
        for(int i=1;i<len-1;i++){
            int left = s.charAt(i-1) - '0';
            int mid = s.charAt(i) - '0';
            int right = s.charAt(i+1) - '0';
            if(mid>left && mid>right) count++;
            else if(mid<left && mid<right) count++;
        }
        return count;
    }
}