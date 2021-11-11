package net.dlm.algo.sort;


/**
 * Created by dmcreynolds on 11/7/2016.
 */
public class MergeSort<T extends Comparable<T>> extends SortImpl<T> implements Sort<T> {
    private final T[] tempMergArr;

    public MergeSort(T[] inputArr) {
        super(inputArr);
        this.tempMergArr = (T[])new Comparable[this.array.length];

    }


    @Override
    protected void sortImpl() {
        sortImplBounded(0, length - 1);
    }

    protected void sortImplBounded(int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            sortImplBounded(lowerIndex, middle);
            // Below step sorts the right side of the array
            sortImplBounded(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if(tempMergArr[i].compareTo(tempMergArr[j]) <= 0) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

    }
}
