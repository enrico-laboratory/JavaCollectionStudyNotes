package com.enricoruggieri.javastudies.greedy_algorithms;

public class greedyAlgorithms01AppleStocks {

    public static int getMaxProfitSecond(int[] stockPrices) {

        if (stockPrices.length < 2 ){
            throw new IllegalArgumentException();
        }

        int minPrice = stockPrices[0];
        int maxProfit = stockPrices[1] - stockPrices[0];

        for (int i = 1; i < stockPrices.length; i++) {

            int currentPrice = stockPrices[i];
            int potentialProfit = currentPrice - minPrice;

            minPrice = Math.min(minPrice, currentPrice);
            maxProfit = Math.max(maxProfit, potentialProfit);
        }

        return maxProfit;
    }

    public static int getMaxProfitFirst(int[] stockPrices) {
        int currentMin = stockPrices[0];
        int currentMax = stockPrices[0];
        int maxProfit = 0;

        for (int price : stockPrices) {
            if (price > currentMax) {
                currentMax = price;
            }
            if (price < currentMin) {
                currentMin = price;
            }
        }
        return currentMax - currentMin;
    }

    public static void main(String[] args) {
        int[] stockPrices = new int[] {10, 7, 5, 8, 11, 9};
        int[] stockPrices1 = new int[] {10, 7, 4, 1, -2, -5};

        System.out.println(getMaxProfitFirst(stockPrices1));
        System.out.println(getMaxProfitSecond(stockPrices1));
    }
}
