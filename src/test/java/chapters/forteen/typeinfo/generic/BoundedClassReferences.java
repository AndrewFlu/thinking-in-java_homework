package chapters.forteen.typeinfo.generic;

import java.util.Arrays;

public class BoundedClassReferences {
    public static void main(String[] args) {
        Class<? extends Number> integerClass = int.class;
        integerClass = double.class;
//        integerClass = String.class; // уже не подходит

        Arrays.stream(integerClass.getDeclaredFields())
                .forEach(System.out::println);
    }
}
