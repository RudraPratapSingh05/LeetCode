class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count =0;
        int curr=0;
        for(int i=0;i<costs.length;i++){
            curr = curr + costs[i];
            if(curr>coins) break;
            count++;
        }
        return count;
    }
}