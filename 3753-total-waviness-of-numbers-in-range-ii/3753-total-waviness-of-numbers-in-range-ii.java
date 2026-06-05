class Solution {
    //memo[index][prevDigit][prevDir] = {count, sum}
    private static final long[][][][] memo = new long[15][11][3][];
    public static long totalWaviness(long num1, long num2) {
        return calc(num2) - calc(num1 - 1);
    }
    private static long calc(long num) {
        if(num < 101) return 0;

        //if number is maxed, just decrement it so we only gotta deal with 15 digits max
        if(num == 1000000000000000L) num--; 

        //find length of num
        int len = 3;
        long x = 1000;
        while(x <= num) {
            x *= 10;
            len++;
        }

        //arr[i] = ith digit from the right
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = (int)(num % 10);
            num /= 10;
        }
        return dfs(arr, len - 1, 10, 1, true)[1];
    }
    private static long[] dfs(int[] arr, int index, int prev, int dir, boolean isTight) {
        if(index == -1) return new long[] {1, 0};
        if(!isTight && memo[index][prev][dir] != null) return memo[index][prev][dir];

        int limit = isTight ? arr[index] : 9;
        long count = 0, sum = 0;
        if(prev == 10) { //if isLeading
            //deal with the case of moving on to the next index without touching anything 
            long[] next = dfs(arr, index - 1, 10, 2, false);
            count += next[0];
            sum += next[1];
            
            
            for(int i = 1; i < limit; i++) {
                next = dfs(arr, index - 1, i, 2, false);
                count += next[0];
                sum += next[1];
            }

            //deal with i = limit seperatly instead of checking every time in the for loop
            next = dfs(arr, index - 1, limit, 2, isTight);
            count += next[0];
            sum += next[1];
        }else {

            for(int i = 0; i < limit; i++) {
                int currentDir = i > prev ? 1 : i < prev ? 0 : 2;

                long[] next = dfs(arr, index - 1, i, currentDir, false);
                count += next[0];
                sum += next[1];
                if((currentDir ^ dir) == 1) sum += next[0];
            }

            //deal with i = limit seperatly instead of checking every time in the for loop
            int currentDir = limit > prev ? 1 : limit < prev ? 0 : 2;
            long[] next = dfs(arr, index - 1, limit, currentDir, isTight);
            count += next[0];
            sum += next[1];
            if((currentDir ^ dir) == 1) sum += next[0];
        }

        long[] ans = new long[] {count, sum};
        if(!isTight) memo[index][prev][dir] = ans;
        return ans;
    }
}