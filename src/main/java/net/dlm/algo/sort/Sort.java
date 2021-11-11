package net.dlm.algo.sort;

/**
 *
 */
public interface Sort<T extends Comparable<T>> {
    T[] sort();
    long getCompCount();

    long getExchanges();

    void printStats();

    String getStats();
}
