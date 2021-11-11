package net.dlm.datastructures;

import net.dlm.datastructures.impl.LIFOStackImpl;

/**
 * Creates stacks of various types of objects backed by
 * specific data structures.
 */
public class StackFactory {
//    publicstatic <T> IStack<T> createLIFOStack() {
//
//    }

    /**
     * Creates an array backed stack with 64 slots.
     *
     * @return An instance of an array backed stack supporting the IStack interface.
     */
    public static <T> IStack<T> createLIFOStackDefaultSize() {
        return createLIFOStack(IStack.DEFAULT_STACK_SIZE);
    }

    /**
     * Creates an array backed stack
     *
     * @param pSize the size of the stack.
     * @param <T>   the type of object to be placed on the stack.
     * @return An instance of an array backed stack supporting the IStack interface.
     */
    public static <T> IStack<T> createLIFOStack(int pSize) {
        return new LIFOStackImpl<T>(pSize);
    }
}
