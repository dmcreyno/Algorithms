package net.dlm.datastructures.impl;

import net.dlm.datastructures.StackEmptyException;
import net.dlm.datastructures.StackFullException;

public class LIFOStackImpl<T> extends AbstractStackBaseImpl<T> {

    /**
     * @param pSize
     */
    public LIFOStackImpl(int pSize) {
        super(pSize);
    }


    @Override
    public void push(T pVal) throws StackFullException, IllegalArgumentException {
        if (ptr < _size - 1) {
            stack.add(++ptr, pVal);
            return;
        }

        throw new StackFullException("stack full");
    }

    @Override
    public T pop() throws StackEmptyException {
        if (ptr > -1) {
            return (stack.get(ptr--));
        }

        throw new StackEmptyException("stack empty");
    }
}
