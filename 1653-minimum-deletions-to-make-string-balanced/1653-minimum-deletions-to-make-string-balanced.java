class Solution {
    public int minimumDeletions(String s) {
        int bcount = 0;
        int deletions = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bcount++;
            } else {
                deletions = Math.min(bcount, deletions + 1);
            }
        }
        return deletions;
    }
}