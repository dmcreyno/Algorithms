package net.dlm.logic;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TableTestCase {
    @Test
    public void testPrint() {
        int val = 8;
        Table tab = new TableTest001(val);
        tab.printHeader();
        tab.print();
    }

    @Test
    public void testPrintHeader() {
        int pCols = 4;
        Table tab = new TableTest001(pCols);
        String h = tab.createHeader();
        assertEquals("A B C D = Y", h);
    }

    private class TableTest001 extends Table {

        /**
         * Default ctor
         *
         * @param pCols
         */
        public TableTest001(int pCols) {
            super(pCols);
        }

        @Override
        boolean logic() {
            updateBitsArrayFromCharArray();
            boolean[] localBits = getBooleanArray();

            return !(( (localBits[IndexMap.A] && localBits[IndexMap.B]) || (localBits[IndexMap.C] && localBits[IndexMap.D]))
                    && ( (localBits[IndexMap.E] && localBits[IndexMap.F]) || (localBits[IndexMap.G] && localBits[IndexMap.H])));
        }
    }
}
