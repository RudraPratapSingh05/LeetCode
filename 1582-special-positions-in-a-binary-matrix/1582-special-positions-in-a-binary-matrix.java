class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[] rowSum = new int[m];
        int[] colSum = new int[n];
        
        // Step 1: Pre-calculate the number of 1s in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    rowSum[i]++;
                    colSum[j]++;
                }
            }
        }
        
        int specialCount = 0;
        
        // Step 2: Identify special positions
        for (int i = 0; i < m; i++) {
            // Optimization: If a row doesn't have exactly one '1', 
            // no element in it can be special.
            if (rowSum[i] == 1) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 1 && colSum[j] == 1) {
                        specialCount++;
                    }
                }
            }
        }
        
        return specialCount;
    }
}