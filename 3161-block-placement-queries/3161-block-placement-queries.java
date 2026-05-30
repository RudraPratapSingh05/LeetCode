import java.util.*;

public class Solution {

    private int[] seg;
    private int size;

    private void update(int pos, int val) {
        pos += size;
        seg[pos] = val;
        pos >>= 1;
        while (pos > 0) {
            seg[pos] = Math.max(seg[2 * pos], seg[2 * pos + 1]);
            pos >>= 1;
        }
    }

    private int query(int l, int r) {
        if (l > r) return 0;
        int res = 0;
        l += size;
        r += size + 1;
        while (l < r) {
            if ((l & 1) == 1) res = Math.max(res, seg[l++]);
            if ((r & 1) == 1) res = Math.max(res, seg[--r]);
            l >>= 1;
            r >>= 1;
        }
        return res;
    }

    public List<Boolean> getResults(int[][] queries) {
        final int MAXV = 50001;
        size = 1;
        while (size < MAXV) size <<= 1;
        seg = new int[2 * size];

        TreeSet<Integer> obs = new TreeSet<>();
        obs.add(0);
        update(0, 0);

        List<Boolean> results = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                int x = q[1];
                obs.add(x);

                Integer next = obs.higher(x);
                update(x, next != null ? next - x : 0);

                Integer prev = obs.lower(x);
                if (prev != null) update(prev, x - prev);

            } else {
                int x = q[1], sz = q[2];

                int lastObs = obs.floor(x);
                // Gap from lastObs to x (boundary) - may be smaller than stored gap
                int gapToX = x - lastObs;

                // For internal gaps, exclude lastObs because its stored gap
                // points to the next obstacle which may be beyond x.
                // Only query gaps for obstacles strictly before lastObs,
                // whose right neighbors are <= lastObs (guaranteed within bounds).
                Integer prevOfLast = obs.lower(lastObs);
                int maxInternal = prevOfLast != null ? query(0, prevOfLast) : 0;

                int maxGap = Math.max(gapToX, maxInternal);
                results.add(maxGap >= sz);
            }
        }

        return results;
    }
}