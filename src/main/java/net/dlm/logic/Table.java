package net.dlm.logic;


/**
 * Prints out a logic table for the logic expression the user supplies. This is just a testing/exploring feature.
 * Possible usage might be to help you verify your Karnaugh mapping transform.
 * Created by dmcreynolds on 1/12/2017.
 * <p><b>Output</b>
 * </p>
 * <pre>
 * A B C D E F G H = Y
 * 0 0 0 0 0 0 0 0 = 1
 * 0 0 0 0 0 0 0 1 = 1
 * 0 0 0 0 0 0 1 0 = 1
 * 0 0 0 0 0 0 1 1 = 0
 * 0 0 0 0 0 1 0 0 = 1
 * 0 0 0 0 0 1 0 1 = 0
 * 0 0 0 0 0 1 1 0 = o
 * 0 0 0 0 0 1 1 1 = 1
 * 0 0 0 0 1 0 0 0 = 1
 * 0 0 0 0 1 0 0 1 = 1
 * </pre>
 */
abstract public class Table {

    private int     _NumOfCols;
    private char[] _c;
    private boolean[] _bits;

    /**
     * Default ctor
     */
    public Table(int pCols) {
        _NumOfCols = pCols;
    }

    /**
     *
     * @return
     */
    public char[] getCharArray() {
        return _c;
    }

    /**
     *
     * @return
     */
    public boolean[] getBooleanArray() {
        return _bits;
    }

    /**
     *
     */
    public void printHeader() {
        System.out.println(createHeader());
    }

    /**
     *
     * @return
     */
    public String createHeader() {
        StringBuilder buf = new StringBuilder();
        char x = 0x41;
        for (int i = 0; i < _NumOfCols; i++) {
            buf.append((char)(x + i));
            buf.append(" ");
        }

        buf.append( "= Y");
        return buf.toString();
    }

    /**
     *
     */
    public void print() {
        StringBuilder buf = new StringBuilder();
        int rows = (int)Math.pow(2, _NumOfCols);

        for(int idx = 0; idx < rows; idx++) {
            buf.append(Integer.toBinaryString(idx));
            while(buf.length() < _NumOfCols) {
                buf.insert(0, "0");
            }

            _c = buf.toString().toCharArray();

            boolean state = logic(); // RESULT

            buf.setLength(0);

            for (int idx2=0; idx2 < _NumOfCols; idx2++) {
                buf.append(_c[idx2]).append(" ");
            }

            buf.append("= ").append(state ? "1":"0");
            System.out.println(buf.toString());
            buf.setLength(0);
        }
    }

    abstract boolean logic();

    /**
     *
     */
    void updateBitsArrayFromCharArray() {
        _bits = new boolean[getCharArray().length];
        for (int j = 0; j < _c.length; j++) {
            _bits[j] = _c[j] == '1';
        }
    }

    /**
     * Array index map for mapping column names to indexes.
     */
    static class IndexMap {
        static int A = 0;
        static int B = 1;
        static int C = 2;
        static int D = 3;
        static int E = 4;
        static int F = 5;
        static int G = 6;
        static int H = 7;
    }
}
