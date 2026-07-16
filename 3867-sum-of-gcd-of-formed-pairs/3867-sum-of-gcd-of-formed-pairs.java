class Solution {
    public long gcdSum(int[] nums) {
        int[] gcdpre = new int[nums.length]; 
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            gcdpre[i] = gcd(nums[i],max);
        }
        Arrays.sort(gcdpre);
        int left = 0;
        int right = gcdpre.length-1;
        long total = 0;
        while(left<right){
            total += gcd(gcdpre[left],gcdpre[right]);
            left++;
            right--;
        }
        return total;
    }
    private int gcd(int a,int b){
        while(b != 0){
            int t = b;
            b = a%b;
            a=t;
        }
        return a;
    }
}