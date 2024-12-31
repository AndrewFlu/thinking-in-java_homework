package chapters.sixteen.arrays.python;

import chapters.sixteen.arrays.generators.converttoprimitives.ConvertTo;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.copyOf;

public class MyList extends List {
    private final Integer[] array;

    public MyList(int[] array) {
        this.array = ConvertTo.object(array);
    }

    public Integer[] getReversed() {
        Integer[] result = copyOf(array, array.length);
        Arrays.sort(result, Collections.reverseOrder());

        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
