package net.dlm.algo.sort;

import java.util.Comparator;


/**
 *
 */
public class QuickSort<T extends Comparable<T>> extends SortImpl<T> implements Sort<T>  {

    public QuickSort(T[] inputArr) {
        super(inputArr);
    }

    @Override
    protected void sortImpl() {
        sortImplBounded(0, length - 1);
    }

    protected void sortImplBounded(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        T pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            comps++;
            while(array[i].compareTo(pivot) < 0) {
                i++;
                comps++;
            }
            comps++;
            while(array[j].compareTo(pivot) > 0) {
                j--;
                comps++;
            }
            if (i <= j) {
                exchangeElements(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        // TODO: Remove the recursion.
        if (lowerIndex < j)
            sortImplBounded(lowerIndex, j);
        if (i < higherIndex)
            sortImplBounded(i, higherIndex);
    }

    public void sortWithComparator2(T[] inputArr, Comparator<T> comp) {

        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSortWithComparatorPrivate(0, length - 1, comp);
    }

    private void quickSortWithComparatorPrivate(int lowerIndex, int higherIndex, Comparator<T> comp) {
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        T pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            comps++;
            while(comp.compare(array[i], pivot) < 0) {
                i++;
                comps++;
            }
            comps++;
            while(comp.compare(array[j], pivot) > 0) {
                j--;
                comps++;
            }
            if (i <= j) {
                exchangeElements(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        // TODO: Remove the recursion.
        if (lowerIndex < j) {
            quickSortWithComparatorPrivate(lowerIndex, j, comp);
        }
        if (i < higherIndex) {
            quickSortWithComparatorPrivate(i, higherIndex, comp);
        }
    }

    private void exchangeElements(int i, int j) {
        exchanges++;
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public String getStats() {
        return null;
    }
}
