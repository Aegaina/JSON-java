package org.json;

import java.util.Map;

/**
 * Define a set of methods to create an instance of Map
 *
 * @author Cathy Zhou
 * @version 2022-06-17
 */
public interface MapFactory {
    /**
     * Create an instance of Map
     */
    Map<String, Object> createMap();

    /**
     * Create an instance of Map
     *
     * @param initialCapacity the initial capacity.
     */
    Map<String, Object> createMap(int initialCapacity);
}