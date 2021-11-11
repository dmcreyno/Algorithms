package net.dlm.algo.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

// org.apache.logging.log4j
/**
 * Cache of a set capacity. Once the capacity is reached, the cache will
 * delete the oldest cached node so as to make room for the new item
 * you want to cache, with caveats - see add.
 */
public class LRUCache<T> {
    private static final Logger logger = LoggerFactory.getLogger(LRUCache.class.getName());
    private final SortedMap<Integer, CacheNode<T>> cache;
    int capacity;


    /**
     * @param capacity size of the cache
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new TreeMap<>();
    }

    /**
     * Adds an item to the cache. The item WILL be added even
     * if the cache is full. If the cache is full, the oldest
     * item will be removed.
     *
     * @param pItem item to be cached
     * @return the item that was passed to be cached
     */
    @SuppressWarnings("unused")
    synchronized T addThisItem(T pItem) {
        logger.info("addThisItem({})", pItem);
        if (this.capacity <= cache.size()) {
            // figure out which item to delete.
            // at the end of this if block, there
            // should be capacity to add the pItem.
            Integer oldestItemKey = cache.firstKey();
            CacheNode<T> oldestNode = cache.get(oldestItemKey);
            if (logger.isInfoEnabled()) {
                // let us tell someone about what we have done.
                logger.info(
                        "Cache was full. Removing \"{}\" to make room for \"{}\" You are welcome.",
                        oldestNode.cachedNode, pItem);
            }

            cache.remove(oldestItemKey);
        }
        CacheNode<T> cacheNode = new CacheNode<>(pItem);
        cache.put(cacheNode.key, cacheNode);
        logger.debug("added item({}). node({})", pItem, cacheNode);
        return pItem;
    }

    /**
     * Pass in a node to delete. The node will be removed from the cache
     * and the function will return the node it deleted. You can compare
     * what you wanted to delete (using other values, not the key obviously)
     * to check the logic of your code.
     *
     * @param pNode CacheNode to delete.
     * @return the node that was removed - may not be the same reference passed.
     */
    @SuppressWarnings("unused")
    synchronized CacheNode<T> deleteNode(CacheNode<T> pNode) {
        CacheNode<T> node = cache.get(pNode.key);
        if (node == null) {
            // If the node is null, then there is no
            // item in the cache with the key you passed
            // and perhaps you just don't know what you
            // are doing, again.
            logger.error("why do you want to delete something, {}, that does not exist?", pNode.key);
        } else {
            cache.remove(node.key);
        }

        return node;
    }

    @SuppressWarnings("unused")
    synchronized CacheNode<T> deleteNodePedantic(CacheNode<T> pNode) {
        CacheNode<T> node = cache.get(pNode.key);
        if (node == null) {
            // If the node is null, then there is no
            // item in the cache with the key you passed
            // and perhaps you just don't know what you
            // are doing, again.
            logger.error(
                    "why do you want to delete something, {}, that does not exist?", pNode.key,
                    new IllegalArgumentException("No such node."));
        }
        return node;
    }

    /**
     * Given a key, look up and return its value.
     *
     * @param key look up value using the <i>key</i>
     */
    public T getValueWithKey(String key) {
        CacheNode<T> node = cache.get(key.hashCode());
        if (null == node) {
            logger.info("CACHE MISS - getValueWithKey({}) : {})", key, key.hashCode());
            return null;
        }
        node.updateTimestamp();
        return node.cachedNode;
    }


    //////////////////////////////////////////////////////////////////////
    // UTILITY STUFF /////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////

    /**
     * Debugging function. Or maybe you just like to print stuff out.
     */
    @SuppressWarnings("unused")
    synchronized void printCacheKeys() {
        if (!logger.isDebugEnabled()) {
            return;
        }

        StringBuilder buf = new StringBuilder("Cache:");

        synchronized (cache) {
            Set<Integer> keySet = this.cache.keySet();
            for (Integer aKey : keySet) {
                buf.append(" [").append(aKey).append("]");
            }
        }
        logger.debug(buf.toString());
    }

    Set<Integer> getKeys() {
        return cache.keySet();
    }
}
