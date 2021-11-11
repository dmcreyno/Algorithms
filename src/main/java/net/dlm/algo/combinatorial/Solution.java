package net.dlm.algo.combinatorial;

import java.util.List;

/**
 * A simple helper class to store the knapsack algorithms solution.
 */
public class Solution {
    // list of items to put in the bag to have the maximal value
    public List<IKnapSackItem> items;
    // maximal value possible
    public int value;

    /**
     *
     * @param items
     * @param value
     */
    public Solution(List<IKnapSackItem> items, int value) {
        this.items = items;
        this.value = value;
    }

    /**
     *
     */
    public void display() {
        if (items != null && !items.isEmpty()) {
            System.out.println("\nKnapsack solution");
            System.out.println("Value = " + value);
            System.out.println("Items to pick :");

            for (IKnapSackItem item : items) {
                System.out.println("- " + item.toString());
            }
        }
    }
}
