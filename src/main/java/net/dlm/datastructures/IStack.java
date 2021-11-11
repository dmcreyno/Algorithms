package net.dlm.datastructures;

public interface IStack<T> {
    /**
     * Constant used in the default createLIFOStackDefaultSize method. The value is 64.
     */
    int DEFAULT_STACK_SIZE = 64;

    @SuppressWarnings("unused")
    interface StackType {
        int FIFO = 128;
        int LIFO = 64;
    }

    void push(T pVal) throws StackFullException;

    T pop() throws StackEmptyException;

    int getSize();
}
