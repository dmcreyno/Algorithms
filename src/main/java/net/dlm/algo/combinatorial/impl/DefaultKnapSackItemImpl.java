package net.dlm.algo.combinatorial.impl;

import net.dlm.algo.combinatorial.IKnapSackItem;

/**
 * The default implementation is intended for testing and is included to illustrate the simplicity of the methods
 * a knapsack item will implement.
 */
public class DefaultKnapSackItemImpl implements IKnapSackItem, Comparable {

    private String name;
    private int value;
    private int weight;
    private Boolean inTheBag = Boolean.FALSE;

    /**
     *
     * @param pName
     * @param pValue
     * @param pWeight
     */
    public DefaultKnapSackItemImpl(String pName, int pValue, int pWeight) {
        this.name = pName;
        this.value = pValue;
        this.weight = pWeight;
    }

    /**
     *
     * @return
     */
    public Boolean isInTheBag() {
        return inTheBag;
    }

    /**
     *
     * @param inTheBag
     */
    public void isInTheBag(Boolean inTheBag) {
        this.inTheBag = inTheBag;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    @Override
    public int getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    @Override
    public void setValue(int value) {
        this.value = value;
    }

    /**
     *
     * @return
     */
    @Override
    public int getWeight() {
        return weight;
    }

    /**
     *
     * @param weight
     */
    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return name + " [value = " + value + ", weight = " + weight + ", inTheBag = " + inTheBag + "]";
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    /**
     * Quick and dirty.
     * TODO - revist
     * @return
     */
    @Override
    public int hashCode() {
        return ("" + name + value + weight).hashCode();
    }

    /**
     * Quick and dirty.
     * TODO - revist
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        } else if(o instanceof  DefaultKnapSackItemImpl) {
            return equals((DefaultKnapSackItemImpl) o );
        }
        return false;
    }

    /**
     * Quick and dirty.
     * TODO - revist
     * @return
     */
    private boolean equals(DefaultKnapSackItemImpl other) {
        return ((""+name+value+weight).equals(""+other.name+other.value+other.weight));
    }
}