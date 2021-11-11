package net.dlm.datastructures.impl;

import net.dlm.datastructures.IStack;

import java.util.ArrayList;

public abstract class AbstractStackBaseImpl<T> implements IStack<T> {
    protected final ArrayList<T> stack = new ArrayList<>();
    protected int _size;
    protected int ptr = -1;
    Class<T> tClass;

    public AbstractStackBaseImpl(int pSize) {
        this._size = pSize;
        for (int i = 0; i < pSize; i++) {
            stack.add(null);
        }
    }

    @Override
    public int getSize() {
        return _size;
    }
}
