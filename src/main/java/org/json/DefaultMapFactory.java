package org.json;

import java.util.HashMap;
import java.util.Map;

/**
 * The default implementation of MapFactory
 *
 * @author Cathy Zhou
 * @version 2022-06-17
 */
class DefaultMapFactory implements MapFactory {
    private DefaultMapFactory() {
    }

    /**
     * Create an instance of Map
     */
    @Override
    public Map<String, Object> createMap() {
        return new HashMap<String, Object>();
    }

    /**
     * Create an instance of Map
     *
     * @param initialCapacity the initial capacity.
     */
    @Override
    public Map<String, Object> createMap(int initialCapacity) {
        return new HashMap<String, Object>(initialCapacity);
    }

    //region static

    private static final DefaultMapFactory instance = new DefaultMapFactory();

    /**
     * Get the instance
     */
    public static DefaultMapFactory getInstance() {
        return instance;
    }

    //endregion
}