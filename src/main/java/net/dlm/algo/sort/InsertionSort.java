package net.dlm.algo.sort;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dmcreynolds on 11/7/2016.
 */
public class InsertionSort<T extends Comparable<T>> extends SortImpl<T> implements Sort<T> {
    Logger logger = LoggerFactory.getLogger(InsertionSort.class);
    private long comparisonCounter;
    private long switchCounter;

    public InsertionSort(T[] inputArray) {
        super(inputArray);
    }

    long getComparisons() {
        return comparisonCounter;
    }

    long getSwitches() {
        return switchCounter;
    }

    @Override
    protected void sortImpl() {
        T temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                comparisonCounter++;
                logger.debug("[{}] - ({}).compareTo({}) < 0", comparisonCounter, array[j], array[j - 1]);
                if (array[j].compareTo(array[j - 1]) < 0) {
                    switchCounter++;
                    logger.debug("[{}] - switch ({}) with ({})", switchCounter, array[j], array[j - 1]);
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
