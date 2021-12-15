package com.enricoruggieri.javastudies.arrays;

public class Array05CafeOrder {

    public static boolean isFirstComeFirstServedSolution(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {
        int takeOutOrdersIndex = 0;
        int dineInOrdersIndex = 0;

        for (int order : servedOrders) {

            // if we still have orders in takeOutOrders
            // and the current order in takeOutOrders is the same
            // as the current order in servedOrders
            if (takeOutOrdersIndex < takeOutOrders.length && order == takeOutOrders[takeOutOrdersIndex]) {
                takeOutOrdersIndex++;

                // if we still have orders in dineInOrders
                // and the current order in dineInOrders is the same
                // as the current order in servedOrders
            } else if (dineInOrdersIndex < dineInOrders.length && order == dineInOrders[dineInOrdersIndex]) {
                dineInOrdersIndex++;

                // if the current order in servedOrders doesn't match the current
                // order in takeOutOrders or dineInOrders, then we're not serving first-come,
                // first-served
            } else {
                return false;
            }
        }

        // check for any extra orders at the end of takeOutOrders or dineInOrders
        if (dineInOrdersIndex != dineInOrders.length || takeOutOrdersIndex != takeOutOrders.length) {
            return false;
        }

        // all orders in servedOrders have been "accounted for"
        // so we're serving first-come, first-served!
        return true;
    }

    public static boolean isFirstComeFirstServed(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {
        int takeOutOrdersCurrentIndex = 0;
        int dineInOrdersCurrentIndex = 0;

        for (int order: servedOrders) {

            boolean isTakeOutOrdersExhausted = takeOutOrdersCurrentIndex >= takeOutOrders.length;
            boolean isDineInOrdersExhausted = dineInOrdersCurrentIndex >= dineInOrders.length;

            if (!isTakeOutOrdersExhausted && order == takeOutOrders[takeOutOrdersCurrentIndex]) {
                System.out.println("Order " + order + " OK!");
                takeOutOrdersCurrentIndex++;
            } else if (!isDineInOrdersExhausted && order == dineInOrders[dineInOrdersCurrentIndex]) {
                System.out.println("Order " + order + " OK!");
                dineInOrdersCurrentIndex++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] takeOutOrders = new int[]{1, 3, 5};
        int[] dineInOrders = new int[]{2, 4, 6};
        int[] servedOrders = new int[]{1, 2, 4, 6, 5, 3};

        int[] takeOutOrders1 = new int[]{17, 8, 24};
        int[] dineInOrders1 = new int[]{12, 19, 2};
        int[] servedOrders1 = new int[]{17, 8, 12, 19, 24, 2};

        int[] takeOutOrders2 = new int[]{2, 4, 6};
        int[] dineInOrders2 = new int[]{1, 3, 5};
        int[] servedOrders2 = new int[]{1, 2, 4, 6, 5, 3};

        System.out.println(isFirstComeFirstServed(takeOutOrders,dineInOrders,servedOrders));
        System.out.println(isFirstComeFirstServed(takeOutOrders1,dineInOrders1,servedOrders1));
        System.out.println(isFirstComeFirstServed(takeOutOrders2,dineInOrders2,servedOrders2));

    }
}
