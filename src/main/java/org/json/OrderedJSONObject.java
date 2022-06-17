package org.json;

import java.util.Locale;
import java.util.Map;

/**
 * An extended JSONObject which keeps the insertion order
 */
public class OrderedJSONObject extends JSONObject {
    //region Constructors

    /**
     * Construct an empty JSONObject.
     */
    public OrderedJSONObject() {
    }

    /**
     * Construct a JSONObject from a subset of another JSONObject. An array of
     * strings is used to identify the keys that should be copied. Missing keys
     * are ignored.
     *
     * @param jo    A JSONObject.
     * @param names An array of strings.
     */
    public OrderedJSONObject(JSONObject jo, String... names) {
        super(jo, names);
    }

    /**
     * Construct a JSONObject from a JSONTokener.
     *
     * @param x A JSONTokener object containing the source string.
     * @throws JSONException If there is a syntax error in the source string or a
     *                       duplicated key.
     */
    public OrderedJSONObject(JSONTokener x) throws JSONException {
        super(x);
    }

    /**
     * Construct a JSONObject from a Map.
     *
     * @param m A map object that can be used to initialize the contents of
     *          the JSONObject.
     * @throws JSONException        If a value in the map is non-finite number.
     * @throws NullPointerException If a key in the map is <code>null</code>
     */
    public OrderedJSONObject(Map<?, ?> m) {
        super(m);
    }

    /**
     * Construct a JSONObject from an Object using bean getters. It reflects on
     * all of the public methods of the object. For each of the methods with no
     * parameters and a name starting with <code>"get"</code> or
     * <code>"is"</code> followed by an uppercase letter, the method is invoked,
     * and a key and the value returned from the getter method are put into the
     * new JSONObject.
     * <p>
     * The key is formed by removing the <code>"get"</code> or <code>"is"</code>
     * prefix. If the second remaining character is not upper case, then the
     * first character is converted to lower case.
     * <p>
     * Methods that are <code>static</code>, return <code>void</code>,
     * have parameters, or are "bridge" methods, are ignored.
     * <p>
     * For example, if an object has a method named <code>"getName"</code>, and
     * if the result of calling <code>object.getName()</code> is
     * <code>"Larry Fine"</code>, then the JSONObject will contain
     * <code>"name": "Larry Fine"</code>.
     * <p>
     * The {@link JSONPropertyName} annotation can be used on a bean getter to
     * override key name used in the JSONObject. For example, using the object
     * above with the <code>getName</code> method, if we annotated it with:
     * <pre>
     * &#64;JSONPropertyName("FullName")
     * public String getName() { return this.name; }
     * </pre>
     * The resulting JSON object would contain <code>"FullName": "Larry Fine"</code>
     * <p>
     * Similarly, the {@link JSONPropertyName} annotation can be used on non-
     * <code>get</code> and <code>is</code> methods. We can also override key
     * name used in the JSONObject as seen below even though the field would normally
     * be ignored:
     * <pre>
     * &#64;JSONPropertyName("FullName")
     * public String fullName() { return this.name; }
     * </pre>
     * The resulting JSON object would contain <code>"FullName": "Larry Fine"</code>
     * <p>
     * The {@link JSONPropertyIgnore} annotation can be used to force the bean property
     * to not be serialized into JSON. If both {@link JSONPropertyIgnore} and
     * {@link JSONPropertyName} are defined on the same method, a depth comparison is
     * performed and the one closest to the concrete class being serialized is used.
     * If both annotations are at the same level, then the {@link JSONPropertyIgnore}
     * annotation takes precedent and the field is not serialized.
     * For example, the following declaration would prevent the <code>getName</code>
     * method from being serialized:
     * <pre>
     * &#64;JSONPropertyName("FullName")
     * &#64;JSONPropertyIgnore
     * public String getName() { return this.name; }
     * </pre>
     * <p>
     *
     * @param bean An object that has getter methods that should be used to make
     *             a JSONObject.
     */
    public OrderedJSONObject(Object bean) {
        super(bean);
    }

    /**
     * Construct a JSONObject from an Object, using reflection to find the
     * public members. The resulting JSONObject's keys will be the strings from
     * the names array, and the values will be the field values associated with
     * those keys in the object. If a key is not found or not visible, then it
     * will not be copied into the new JSONObject.
     *
     * @param object An object that has fields that should be used to make a
     *               JSONObject.
     * @param names  An array of strings, the names of the fields to be obtained
     */
    public OrderedJSONObject(Object object, String... names) {
        super(object, names);
    }

    /**
     * Construct a JSONObject from a source JSON text string. This is the most
     * commonly used JSONObject constructor.
     *
     * @param source A string beginning with <code>{</code>&nbsp;<small>(left
     *               brace)</small> and ending with <code>}</code>
     *               &nbsp;<small>(right brace)</small>.
     * @throws JSONException If there is a syntax error in the source string or a
     *                       duplicated key.
     */
    public OrderedJSONObject(String source) throws JSONException {
        super(source);
    }

    /**
     * Construct a JSONObject from a ResourceBundle.
     *
     * @param baseName The ResourceBundle base name.
     * @param locale   The Locale to load the ResourceBundle for.
     * @throws JSONException If any JSONExceptions are detected.
     */
    public OrderedJSONObject(String baseName, Locale locale) throws JSONException {
        super(baseName, locale);
    }

    /**
     * Constructor to specify an initial capacity of the internal map. Useful for library
     * internal calls where we know, or at least can best guess, how big this JSONObject
     * will be.
     *
     * @param initialCapacity initial capacity of the internal map.
     */
    protected OrderedJSONObject(int initialCapacity) {
        super(initialCapacity);
    }

    //endregion

    /**
     * Returns the factory used to create the map
     */
    @Override
    protected MapFactory getMapFactory() {
        return OrderedMapFactory.getInstance();
    }
}