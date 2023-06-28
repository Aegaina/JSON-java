package org.json;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A MapFactory produces ordered maps
 *
 * @author Cathy Zhou
 * @version 2022-06-17
 */
public class OrderedMapFactory implements MapFactory {
    private OrderedMapFactory() {
    }

    /**
     * Create an instance of Map
     */
    @Override
    public Map<String, Object> createMap() {
        return new LinkedHashMap<String, Object>();
    }

    /**
     * Create an instance of Map
     *
     * @param initialCapacity the initial capacity.
     */
    @Override
    public Map<String, Object> createMap(int initialCapacity) {
        return new LinkedHashMap<String, Object>(initialCapacity);
    }

    //region static

    private static final OrderedMapFactory instance = new OrderedMapFactory();

    /**
     * Get the instance
     */
    public static OrderedMapFactory getInstance() {
        return instance;
    }

    //endregion
}
