package net.dlm.algo.cache;

/**
 * A wrapper for items going into the cache. Used a wrapper to avoid
 * polluting the cached item's interface with things related only to
 * the ability to be cached. Items should not have any knowledge of
 * the cache.
 */
class CacheNode<T> implements Comparable<CacheNode<T>> {
    Long timestamp;

    T cachedNode;
    int key;

    /**
     * The only constructor. If you are creating a cache node then
     * you should already have something to cache.
     *
     * @param obj
     */
    public CacheNode(T obj) {
        this.key = obj.hashCode();
        this.timestamp = System.currentTimeMillis(); // TODO stupid simple for now.
        this.cachedNode = obj;
    }

    /**
     * Probably not going to be used much in the average application.
     * This function returns the key of the item this class instance
     * is wrapping.
     *
     * @return
     */
    public Integer getKey() {
        this.updateTimestamp();
        return key;
    }

    /**
     * Returns the wrapped object. Most applications will not need to
     * use this function. The cache should not require the clients
     * to know about the CachedNode class, considering the CachedNode class
     * is package protected, doh!
     *
     * @return
     */
    T getCachedNode() {
        this.updateTimestamp();
        return cachedNode;
    }

    /**
     * Get the cached value. Most applications will not need to
     * use this function. The cache should not require the clients
     * to know about the CachedNode class, considering the CachedNode class
     * is package protected, double doh!
     *
     * @return
     */
    public T getValue() {
        this.updateTimestamp();
        return this.cachedNode;
    }

    Long getTimestamp() {
        return timestamp;
    }

    void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(CacheNode<T> other) {
        return this.timestamp.compareTo(other.timestamp);
    }

    /**
     * Update timestamp on this reference.
     */
    void updateTimestamp() {
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "CacheNode{" +
                "timestamp=" + timestamp +
                ", cachedNode=" + cachedNode +
                ", key=" + key +
                '}';
    }
}
