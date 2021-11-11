package net.dlm.algo.combinatorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic solution to the classic Knapsack problem from computer science.
 */
public class KnapsackAlgo {
    static final Logger logger = LoggerFactory.getLogger(KnapsackAlgo.class);

    // items of our problem
    private final IKnapSackItem[] items;
    // capacity of the bag
    private final int capacity;

    /**
     *
     * @param items the items to analyze
     * @param capacity the capacity of the knapsack
     */
    public KnapsackAlgo(IKnapSackItem[] items, int capacity) {
        this.items = items;
        this.capacity = capacity;
    }

    public IKnapSackItem[] getItems() {
        return items;
    }

    public int getCapacity() {
        return capacity;
    }

    public void display() {
        if (items != null  &&  items.length > 0) {
            System.out.println("\n\n#################################");
            System.out.println("Knapsack problem");
            System.out.println("Capacity : " + capacity);
            System.out.println("Items :");

            for (IKnapSackItem item : items) {
                System.out.println("- " + item.toString());
            }
        }
    }

    // we write the solve algorithm
    public Solution solve() {
        int NB_ITEMS = items.length;
        // we use a matrix to store the max value at each n-th item
        int[][] matrix = new int[NB_ITEMS + 1][capacity + 1];

        // first line is initialized to 0
        for (int i = 0; i <= capacity; i++)
            matrix[0][i] = 0;

        // we iterate on items
        for (int i = 1; i <= NB_ITEMS; i++) {
            // we iterate on each capacity
            for (int j = 0; j <= capacity; j++) {
                if (items[i - 1].getWeight() > j)
                    matrix[i][j] = matrix[i-1][j];
                else
                    // we maximize value at this rank in the matrix
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j - items[i-1].getWeight()]
                            + items[i-1].getValue());
            }
        }

        int res = matrix[NB_ITEMS][capacity];
        int w = capacity;
        List<IKnapSackItem> itemsSolution = new ArrayList<>();

        for (int i = NB_ITEMS; i > 0  &&  res > 0; i--) {
            if (res != matrix[i-1][w]) {
                itemsSolution.add(items[i-1]);
                items[i-1].isInTheBag(Boolean.TRUE);
                // we remove items value and weight
                res -= items[i-1].getValue();
                w -= items[i-1].getWeight();
            }
        }

        return new Solution(itemsSolution, matrix[NB_ITEMS][capacity]);
    }

    public List<IKnapSackItem> getLeftOverItems() {
        List<IKnapSackItem> leftOvers = new ArrayList<>();

        for (IKnapSackItem anItem:items) {
            if(!anItem.isInTheBag()) {
                leftOvers.add(anItem);
            }
        }

        return leftOvers;
    }
}
