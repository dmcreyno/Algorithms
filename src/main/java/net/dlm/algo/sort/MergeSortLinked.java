package net.dlm.algo.sort;


/**
 * Created by dmcreynolds on 11/11/2016.
 */
public class MergeSortLinked<T extends Node<Comparable>>{
    public MergeSortLinked(T[] inputArr) {
        /*super(inputArr);*/
    }
    int mergedList = 0;

    protected void sortImpl() {

    }

    private void mergesortLinked(int low, int high) {
        int mid = 0;
        int list1 = 0;
        int list2 = 0;

        if(low == high) {
            mergedList = low;
            //array[mergedList].set;
        }
    }
}
