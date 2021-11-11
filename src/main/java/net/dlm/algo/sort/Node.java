package net.dlm.algo.sort;


/**
 * Created by dmcreynolds on 11/11/2016.
 */
public class Node<K extends Comparable>  {
    private K key;
    private Node<K> data;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public Node<K> getData() {
        return data;
    }

    public void setData(Node<K> data) {
        this.data = data;
    }

    public String toString() {
        return "Node: " + key;
    }
}
