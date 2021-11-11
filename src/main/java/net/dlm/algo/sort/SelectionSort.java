package net.dlm.algo.sort;


/**
 * Created by dmcreynolds on 11/7/2016.
 */
public class SelectionSort<T extends Comparable<T>> extends SortImpl<T> implements Sort<T> {

    public SelectionSort(T[] inputArray) {
        super(inputArray);
    }

    protected void sortImpl() {
        for (int i = 0; i < this.array.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < this.array.length; j++) {
                comps++;
                int compVal = this.array[j].compareTo(this.array[index]);
                if (compVal < 0) {
                    index = j;
                }
            }
            T smallerNumber = this.array[index];
            this.array[index] = this.array[i];
            this.array[i] = smallerNumber;
        }
    }
}
