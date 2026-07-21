class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        String t = "1" + s + "1";
        int n = t.length();
        
        // Parse into blocks: char and length
        List<Character> blockChar = new ArrayList<>();
        List<Integer> blockLen = new ArrayList<>();
        
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && t.charAt(j) == t.charAt(i)) {
                j++;
            }
            blockChar.add(t.charAt(i));
            blockLen.add(j - i);
            i = j;
        }
        
        int m = blockChar.size();
        int totalOnes = 0;
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) == '1') totalOnes++;
        }
        
        // Collect zero blocks: (length, index), sorted descending by length
        List<int[]> zeroList = new ArrayList<>();
        for (int idx = 0; idx < m; idx++) {
            if (blockChar.get(idx) == '0') {
                zeroList.add(new int[]{blockLen.get(idx), idx});
            }
        }
        zeroList.sort((a, b) -> b[0] - a[0]);
        
        List<int[]> top3 = zeroList.subList(0, Math.min(3, zeroList.size()));
        
        Integer bestGain = null;
        
        for (int idx = 1; idx < m - 1; idx++) {
            if (blockChar.get(idx) == '1') {
                int c = blockLen.get(idx);
                int p = blockLen.get(idx - 1);
                int q = blockLen.get(idx + 1);
                
                int exclA = idx - 1;
                int exclB = idx + 1;
                
                int maxOther = 0;
                for (int[] pair : top3) {
                    int val = pair[0];
                    int bidx = pair[1];
                    if (bidx != exclA && bidx != exclB) {
                        maxOther = val;
                        break;
                    }
                }
                
                int gain = Math.max(p + q, maxOther - c);
                
                if (bestGain == null || gain > bestGain) {
                    bestGain = gain;
                }
            }
        }
        
        if (bestGain == null) {
            return totalOnes;
        }
        return totalOnes + Math.max(0, bestGain);
    }
}