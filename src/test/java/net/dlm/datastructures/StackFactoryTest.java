package net.dlm.datastructures;


import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


class StackFactoryTest {

    @Test
    void createArrayBackedStack() {
        IStack<BigInteger> stk = StackFactory.createLIFOStack(3);
        stk.push(BigInteger.ZERO);
        stk.push(BigInteger.ONE);
        stk.push(BigInteger.TEN);

        assertEquals(BigInteger.TEN, stk.pop());
        assertEquals(BigInteger.ONE, stk.pop());
        assertEquals(BigInteger.ZERO, stk.pop());
    }

    @Test
    void exceptionsArrayBackedStack() {
        IStack<BigInteger> stk = StackFactory.createLIFOStack(3);
        stk.push(BigInteger.ZERO);
        stk.push(BigInteger.ONE);
        stk.push(BigInteger.TEN);

        try {
            stk.push(new BigInteger("2048"));
            fail();
        } catch (StackFullException sfe) {

        }

        assertEquals(BigInteger.TEN, stk.pop());
        assertEquals(BigInteger.ONE, stk.pop());
        assertEquals(BigInteger.ZERO, stk.pop());
        try {
            stk.pop();
            fail();
        } catch (StackEmptyException sfe) {

        }
    }

    @Test
    void defaultCreateArrayBackedStack() {
        IStack<BigDecimal> stk = StackFactory.createLIFOStackDefaultSize();
        int stackSize = stk.getSize();
        assertEquals(IStack.DEFAULT_STACK_SIZE, stackSize);
    }
}
