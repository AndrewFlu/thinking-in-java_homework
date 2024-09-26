package chapters.forteen.typeinfo.generic;

import java.util.Arrays;

public class WildCardClassReferences {
    public static void main(String[] args) {
        Class<?> integerClass = int.class;
        integerClass = double.class;
        integerClass = String.class;

        Arrays.stream(integerClass.getDeclaredFields())
                .forEach(System.out::println);
    }
}
