class Solution {
    public int maxProfit(int[] prices) {
        int maxCur = 0;//max profit end with current point
        int maxSofar = 0;//max profit to so far

        for (int i = 1; i < prices.length; i++) {
            //By reseting maxCur to 0, essentially it means that we have found a point i where the price[i] is lower than the time we bought, and that we should then try to buy at point i to see if we can achieve a bigger gain. Because maxCur is recording the difference, the difference between price[i] and itself should be 0.
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSofar = Math.max(maxSofar, maxCur);
        }

        return maxSofar;
    }
}



class Solution {
    public int maxProfit(int[] prices) {
        int buyOne = Integer.MAX_VALUE;
        int sellOne = 0;

        for (int i : prices) {
            buyOne = Math.min(i, buyOne);//choose the lowest one
            sellOne = Math.max(sellOne, i - buyOne);//consider every i as sell point
        }

        return sellOne;
    }
}
