package chapters.twenty.annotations.atunit.generics;

import chapters.twenty.annotations.base_syntax.Test;

import java.util.HashMap;

public class HashMapTest {
    HashMap<Integer, String> testObject = new HashMap<>();

    @Test
    void initialization() {
        assert testObject.isEmpty();
    }

    @Test
    void _containsValue() {
        testObject.put(1, "one");
        assert testObject.containsValue("one");
    }

    @Test
    void _containsKey() {
        testObject.put(1, "one");
        assert testObject.containsKey(1);
    }

    @Test
    void _remove() {
        testObject.put(1, "one");
        testObject.remove(1);

        assert testObject.isEmpty();
    }

    @Test
    void _get() {
        testObject.put(1, "one");
        assert testObject.get(1).equals("one");
    }

    @Test
    void _size() {
        testObject.put(1, "one");
        testObject.put(2, "two");

        assert testObject.size() == 2;
    }

    @Test
    void _clear() {
        testObject.put(1, "one");
        assert !testObject.isEmpty();

        testObject.clear();
        assert testObject.isEmpty();
    }

}
