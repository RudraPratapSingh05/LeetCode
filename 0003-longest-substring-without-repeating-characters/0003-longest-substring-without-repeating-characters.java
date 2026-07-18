class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        Set<Character> substr = new HashSet<>();
        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            while(substr.contains(c)){
                substr.remove(s.charAt(left));
                left++;
            }
            substr.add(c);
            max = Math.max(max,substr.size());
        }
        return max;
    }
}