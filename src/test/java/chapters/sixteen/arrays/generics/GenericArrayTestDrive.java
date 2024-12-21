package chapters.sixteen.arrays.generics;

import java.util.Arrays;
import java.util.Date;

public class GenericArrayTestDrive {
    public static void main(String[] args) {
        String[] strings = new String[2];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = "Str_" + new Date().getTime();
        }
        System.out.println(Arrays.toString(strings));

        Object[] objects = new Object[3];
        objects[0] = "First";
        objects[1] = 2;
        objects[2] = 'a';
        System.out.println(Arrays.toString(objects));
    }
}
