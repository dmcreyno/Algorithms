package net.dlm.algo.sort;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for the various sorting algorithms. Assumes the items to be
 * sorted can be kept in an array of type T.
 * <p>
 * Includes metrics for tracking the number of compare operations and exchanges.
 */
public abstract class SortImpl<T extends Comparable<T>> implements Sort<T> {
    private static final Logger logger = LoggerFactory.getLogger("SortAlgoBaseClass");
    protected long comps = 0;     // Tracks the number of comparisons
    protected long exchanges = 0; // Tracks the number of exchanges

    protected T[] array;
    protected int length;

    public SortImpl(T[] inputArr) {
        this.array = inputArr;
        length = inputArr.length;
    }

    public T[] sort() {

        if (array == null){
            logger.error("nothing to sort. the array is null.");
            throw new IllegalArgumentException("Null collection.");
        }

        if (array.length == 0) {
            // Throw an exception because if you are
            // trying to sort an empty array then maybe
            // you do not know what you are doing.
            logger.error("nothing to sort. the array is empty.");
            throw new IllegalArgumentException("Empty collection.");
        }
        sortImpl();
        return array;
    }

    abstract protected void sortImpl();

    public long getCompCount() {
        return comps;
    }

    public long getExchanges() {
        return exchanges;
    }

    public void printStats() {
        if (!logger.isDebugEnabled()) {
            return;
        }

        StringBuilder buf = new StringBuilder();
        buf.append(this.getClass().getName()).append(": COMPS[").append(comps).append("] - EXCHS[").append(exchanges).append("]");
        logger.debug(buf.toString());
    }

    public String getStats() {
        StringBuilder buf = new StringBuilder();
        buf.append(this.getClass().getName()).append(": COMPS[").append(comps).append("] - EXCHS[").append(exchanges).append("]");
        return buf.toString();
    }
}
