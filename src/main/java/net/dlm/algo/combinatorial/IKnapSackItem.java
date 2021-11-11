package net.dlm.algo.combinatorial;

import java.math.BigDecimal;

/**
 * Interface implemented by items we intend to put in our Knapsack.
 */
public interface IKnapSackItem {
    /**
     *
     * @return
     */
    String getName();

    /**
     *
     * @param name
     */
    void setName(String name);

    /**
     *
     * @return
     */
    int getValue();

    /**
     *
     * @param value
     */
    void setValue(int value);

    /**
     *
     * @return
     */
    int getWeight();

    /**
     *
     * @param weight
     */
    void setWeight(int weight);

    /**
     * This method is intended to help with those situations where the number of items to process
     * far exceeds the capacity of the Knapsack. In these situations, one may call the Knapsack
     * algorithm recursively then, to process the "leftover" items until no items have been left.
     *
     * Think of a work queue where resources are limited and you want to process the items through the work queue
     * in an efficient order.
     * @return
     */
    Boolean isInTheBag();

    /**
     *
     * @param pInTheBag
     */
    void isInTheBag(Boolean pInTheBag);
}
