public int maxProfit(int[] prices) {
      int buyOne = Integer.MAX_VALUE;
      int sellOne = 0;
      int buyTwo = Integer.MAX_VALUE;
      int sellTwo = 0;

      for (int i : prices) {
          buyOne = Math.min(i, buyOne);//choose the lowest one
          sellOne = Math.max(sellOne, i - buyOne);//consider every i as sell point
          buyTwo = Math.min(buyTwo, i - sellOne);//choose lowest one compare with sellOne
          sellTwo = Math.max(sellTwo, i - buyTwo);//consider every i as sell point
      }

      return sellTwo;
}
