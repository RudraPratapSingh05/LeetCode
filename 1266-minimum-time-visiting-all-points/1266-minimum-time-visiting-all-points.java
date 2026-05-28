class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totaltime=0;
        for(int i=0;i<points.length-1;i++){
            int x1=points[i][0], y1=points[i][1];
            int x2=points[i+1][0], y2=points[i+1][1];
            int dx = Math.abs(x2-x1);
            int dy = Math.abs(y2-y1);
            totaltime += Math.max(dx,dy);
        }
        return totaltime;
    }
}