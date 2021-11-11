package net.dlm.algo.cache;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class TestNode {

    private final String ID;
    private final String someData;


    public TestNode(String ID, String someData) {
        this.ID = ID;
        this.someData = someData;
    }

    public String getID() {
        return ID;
    }

    public String getSomeData() {
        return someData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof TestNode)) return false;

        TestNode testNode = (TestNode) o;

        return new EqualsBuilder().append(ID, testNode.ID).isEquals();
    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("TestNode[").append(this.ID).append("]");

        return buf.toString();
    }

}
