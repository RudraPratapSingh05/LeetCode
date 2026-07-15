class Solution {
    public int gcdOfOddEvenSums(int n) {
        int oddsum = 0;
        int evensum = 0;
        int o = 1;
        int p = 2;
        for(int i=0;i<n;i++){
            oddsum += o;
            o+=2;
        }
        for(int i=0;i<n;i++){
            evensum += p;
            p+=2;
        }
        while(evensum!=0){
            int temp = evensum;
            evensum = oddsum%evensum;
            oddsum = temp;
        }
        return oddsum;
    }
}