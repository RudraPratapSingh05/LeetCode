class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Set<Integer> num = new HashSet<>();
        for(int n:nums) num.add(n);
        int longest = 1;
        for(int n:num){
            if(!num.contains(n-1)){
                int curr=1;
                while(num.contains(n+curr)) curr++;
                longest = Math.max(longest,curr);
            }
        }
        return longest;
    }
}