package net.dlm.algo.combinatorial.impl;

import net.dlm.algo.combinatorial.IKnapSackItem;
import net.dlm.algo.combinatorial.KnapsackAlgo;
import net.dlm.algo.combinatorial.Solution;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class KnapSackDPTestCase {

    @Test
    public void testDefaultItemImpl() {
        // we take the same instance of the problem displayed in the image
        IKnapSackItem[] items = {
                new DefaultKnapSackItemImpl("Elt1", 4, 12),
                new DefaultKnapSackItemImpl("Elt2", 2, 1),
                new DefaultKnapSackItemImpl("Elt3", 2, 2),
                new DefaultKnapSackItemImpl("Elt4", 1, 1),
                new DefaultKnapSackItemImpl("Elt5", 10, 4)
        };

        KnapsackAlgo knapsack = new KnapsackAlgo(items, 16);
//        knapsack.display();
        Solution solution = knapsack.solve();
//        solution.display();
        assertEquals("Solution value not correct.", 15, solution.value);
        assertTrue(solution.items.contains(items[1]));
        assertTrue(solution.items.contains(items[2]));
        assertTrue(solution.items.contains(items[3]));
        assertTrue(solution.items.contains(items[4]));
    }

}
