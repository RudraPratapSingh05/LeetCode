class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for(String wo:patterns){
            if(word.contains(wo)){
                count++;
            }
        }
        return count;
    }
}