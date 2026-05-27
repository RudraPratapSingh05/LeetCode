class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase()) || word.equals(word.toLowerCase())) {
            return true;
        }
        String suffix = word.substring(1);
        return Character.isUpperCase(word.charAt(0)) && suffix.equals(suffix.toLowerCase());
    }
}