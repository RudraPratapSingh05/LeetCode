class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // Step 1: Build frequency array (count bars at each price)
        int maxCost = 100000;
        int[] freq = new int[maxCost + 1];

        for (int cost : costs) {
            freq[cost]++;
        }

        // Step 2: Greedily buy cheapest bars first
        int count = 0;

        for (int price = 1; price <= maxCost; price++) {
            if (coins < price) break; // Can't afford anything from here on

            // Buy as many bars at this price as possible
            int canBuy = Math.min(freq[price], coins / price);
            count += canBuy;
            coins -= canBuy * price;
        }
        return count;
    }
}