/*
  Example 1:

	 Input: prices = [7,1,5,3,6,4]
	 Output: 5
	 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
	 Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

  Example 2:

	 Input: prices = [7,6,4,3,1]
	 Output: 0
	 Explanation: In this case, no transactions are done and the max profit = 0.
*/

public class BestTimetoBuyandSellStock {

	//Brute Force = Time complexity: O(n^2) and Space complexity: O(1)
	public static int maxProfit1(int[] prices) {
		int maxprofit = 0;
		
		for(int i = 0; i < prices.length - 1; i++) {
			for(int j = i + 1; j < prices.length; j++) {
				int profit = prices[j] - prices[i];
				if(profit > maxprofit)
					maxprofit = profit;
			}
		}
	 
		return maxprofit;
	}
	
	//Time complexity: O(n) and Space complexity: O(1)
	public static int maxProfit2(int[] prices) {
		int buy = Integer.MAX_VALUE;
		int maxprofit = 0;
		
		for(int i = 0; i < prices.length; i++) {
				
			     if(prices[i] < buy) {
					buy = prices[i];
			     }
				 
				 if(prices[i] - buy > maxprofit) {
			    	 maxprofit = prices[i] - buy;
			     }
		}
	 
		return maxprofit;
	}
	
	//Time complexity: O(n) and Space complexity: O(1)
	public static int maxProfit3(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

	public static void main(String[] args) {
		int[] price1 = {7,1,5,3,6,4};
		System.out.println("Buying and Selling for the array [7,1,5,3,6,4] = " + maxProfit1(price1));
		
		int[] price2 = {7,6,4,3,1};
		System.out.println("Buying and Selling for the array [7,6,4,3,1] = " + maxProfit2(price2));
        
		int[] price3 = {7,6,4,3,1};
		System.out.println("Buying and Selling for the array [7,6,4,3,1] = " + maxProfit3(price3));
	}
}
