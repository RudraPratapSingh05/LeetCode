import java.util.Arrays;

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;

        int[] landEnd = new int[n];
        for (int i = 0; i < n; i++)
            landEnd[i] = landStartTime[i] + landDuration[i];

        int[] waterEnd = new int[m];
        for (int j = 0; j < m; j++)
            waterEnd[j] = waterStartTime[j] + waterDuration[j];

        int ans = Integer.MAX_VALUE;

        Integer[] waterByStart = new Integer[m];
        for (int j = 0; j < m; j++) waterByStart[j] = j;
        Arrays.sort(waterByStart, (a, b) -> Integer.compare(waterStartTime[a], waterStartTime[b]));

        Integer[] landByEnd = new Integer[n];
        for (int i = 0; i < n; i++) landByEnd[i] = i;
        Arrays.sort(landByEnd, (a, b) -> Integer.compare(landEnd[a], landEnd[b]));

        int minLandEnd = Integer.MAX_VALUE;
        int li = 0;

        for (int jIdx = 0; jIdx < m; jIdx++) {
            int j = waterByStart[jIdx];
            int ws = waterStartTime[j];
            int wd = waterDuration[j];

            while (li < n && landEnd[landByEnd[li]] <= ws) {
                minLandEnd = Math.min(minLandEnd, landEnd[landByEnd[li]]);
                li++;
            }

            if (minLandEnd != Integer.MAX_VALUE)
                ans = Math.min(ans, ws + wd);

            if (li < n)
                ans = Math.min(ans, landEnd[landByEnd[li]] + wd);
        }

        Integer[] landByStart = new Integer[n];
        for (int i = 0; i < n; i++) landByStart[i] = i;
        Arrays.sort(landByStart, (a, b) -> Integer.compare(landStartTime[a], landStartTime[b]));

        Integer[] waterByEnd = new Integer[m];
        for (int j = 0; j < m; j++) waterByEnd[j] = j;
        Arrays.sort(waterByEnd, (a, b) -> Integer.compare(waterEnd[a], waterEnd[b]));

        int minWaterEnd = Integer.MAX_VALUE;
        int wi = 0;

        for (int iIdx = 0; iIdx < n; iIdx++) {
            int i = landByStart[iIdx];
            int ls = landStartTime[i];
            int ld = landDuration[i];

            while (wi < m && waterEnd[waterByEnd[wi]] <= ls) {
                minWaterEnd = Math.min(minWaterEnd, waterEnd[waterByEnd[wi]]);
                wi++;
            }

            if (minWaterEnd != Integer.MAX_VALUE)
                ans = Math.min(ans, ls + ld);

            if (wi < m)
                ans = Math.min(ans, waterEnd[waterByEnd[wi]] + ld);
        }

        return ans;
    }
}