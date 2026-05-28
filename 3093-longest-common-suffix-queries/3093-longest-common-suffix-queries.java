class Solution {
    int[][] trieNext;
    int[] trieBest;
    int trieSize;

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        // Calculate actual max nodes needed
        int totalChars = 0;
        for (String w : wordsContainer) totalChars += w.length();
        int maxNodes = totalChars + 1;

        trieNext = new int[maxNodes][26];
        trieBest = new int[maxNodes];
        trieSize = 1;

        for (int[] row : trieNext) java.util.Arrays.fill(row, -1);
        java.util.Arrays.fill(trieBest, -1);

        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i, wordsContainer);
        }

        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = query(wordsQuery[i]);
        }
        return ans;
    }

    private void insert(String word, int idx, String[] container) {
        int node = 0;
        updateBest(node, idx, container);

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (trieNext[node][c] == -1) {
                trieNext[node][c] = trieSize++;
            }
            node = trieNext[node][c];
            updateBest(node, idx, container);
        }
    }

    private void updateBest(int node, int idx, String[] container) {
        if (trieBest[node] == -1 ||
            container[idx].length() < container[trieBest[node]].length()) {
            trieBest[node] = idx;
        }
    }

    private int query(String word) {
        int node = 0;
        int best = trieBest[0];

        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (trieNext[node][c] == -1) break;
            node = trieNext[node][c];
            best = trieBest[node];
        }
        return best;
    }
}  