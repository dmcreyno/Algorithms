package net.dlm.algo.cache;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;


public class LRUCacheTestCase {
    Logger logger = LoggerFactory.getLogger(LRUCacheTestCase.class);


    //////////////////////////////////////////////////////////
    // UTILITIES
    //////////////////////////////////////////////////////////
    private static LRUCache<TestNode> initCache(TestNode[] testNodeArray) throws Exception {
        LRUCache<TestNode> cache = new LRUCache<>(testNodeArray.length);
        for (TestNode testNode : testNodeArray) {
            cache.addThisItem(testNode);
            Thread.sleep(8);
        }
        return cache;
    }

    @Test
    public void sortedCacheKeys() throws Exception {
        TestNode[] testNodes = LRUCacheTestCase.initTestNodeArray(4);
        LRUCache<TestNode> cache = LRUCacheTestCase.initCache(testNodes);
        Integer[] keyArray = new Integer[testNodes.length];
        keyArray = cache.getKeys().toArray(keyArray);
        for (int i = 0; i < keyArray.length - 1; i++) {
            int diff = keyArray[i] - keyArray[i + 1];
            logger.debug("Comparing {} and {}. Result is {}", keyArray[i], keyArray[i + 1], diff);
            assertTrue(diff < 0);
        }
    }

    @Test
    public void lookupItemsToCapacity() throws Exception {
        TestNode[] testNodes = LRUCacheTestCase.initTestNodeArray(4);
        LRUCache<TestNode> cache = LRUCacheTestCase.initCache(testNodes);

        TestNode searchForMe = testNodes[2];
        TestNode youFoundMe = cache.getValueWithKey(searchForMe.getID());
        assertEquals(searchForMe, youFoundMe);
    }

    @Test
    public void addItemsOverCapacity() throws Exception {
        TestNode[] testNodes = LRUCacheTestCase.initTestNodeArray(4);
        LRUCache<TestNode> cache = LRUCacheTestCase.initCache(testNodes);

        // Push out the oldest item.
        TestNode newItemOverCapacity = new TestNode(
                String.valueOf(System.currentTimeMillis()),
                "Over Capacity 1");
        cache.addThisItem(newItemOverCapacity);

        TestNode searchForMe = testNodes[0]; // Zero should be the oldest item.
        TestNode youFoundMe = cache.getValueWithKey(searchForMe.getID());
        assertNull(youFoundMe);

        // just for fun, let's find the item we just added.
        youFoundMe = cache.getValueWithKey(newItemOverCapacity.getID());
        assertEquals(newItemOverCapacity, youFoundMe);
    }

    @SuppressWarnings("all")
    private static TestNode[] initTestNodeArray(int pCapacity) throws Exception {
        TestNode[] testNodeArray = new TestNode[pCapacity];
        for (int i = 0; i < pCapacity; i++) {
            TestNode node = new TestNode(String.valueOf(System.currentTimeMillis()), "TestNode[" + i + "]");
            testNodeArray[i] = node;
            Thread.sleep(5);
        }
        return testNodeArray;
    }

    @Test
    @SuppressWarnings("all")
    public void createCache() {
        LRUCache<TestNode> cache;
        cache = new LRUCache<>(16);
        cache = new LRUCache<>(4096);
        cache = new LRUCache<>(3000000);
        cache = new LRUCache<>(10000000);
    }

}
