package chapters.seventeen.containers;

import java.util.ArrayList;
import java.util.List;

public class StringContainer {
    private int size;
    private String[] stringArray;

    public StringContainer(int size) {
        stringArray = new String[size];
    }

    public void add(String s) {
        // если массив заполнен полностью, расширим массив, создав новый,
        // увеличенный на половину длины
        if (size == stringArray.length) {
            String[] extendedArray = new String[stringArray.length + stringArray.length / 2];
            System.arraycopy(stringArray, 0, extendedArray, 0, stringArray.length);
        }
        stringArray[size++] = s;
    }

    public String get(int index) {
        if (index < 0)
            throw new IllegalArgumentException("Индекс не должен быть отрицательным числом");
        if (index >= size)
            throw new IllegalArgumentException("Желаемый индекс БОЛЬШЕ размера массива");
        return stringArray[index];
    }

    public int size() {
        return size;
    }


    class TestStringContainer {
        static final int LOOPS = 10_000;
        static List<Test<List<String>>> listTests = new ArrayList<>();
        static List<Test<StringContainer>> stringContainerTests = new ArrayList<>();

        static {

            // List tests
            listTests.add(new Test<List<String>>("add") {
                @Override
                int test(List<String> container, TestParam tp) {
                    for (int i = 0; i < LOOPS; i++) {
                        container.add(Integer.toString(i));
                    }
                    return LOOPS;
                }
            });
            listTests.add(new Test<List<String>>("get") {
                @Override
                int test(List<String> container, TestParam tp) {
                    for (int i = 0; i < LOOPS; i++) {
                        container.get(i);
                    }
                    return LOOPS;
                }
            });

            // StringContainer tests
            stringContainerTests.add(new Test<StringContainer>("add") {
                @Override
                int test(StringContainer container, TestParam tp) {
                    for (int i = 0; i < LOOPS; i++) {
                        container.add(Integer.toString(i));
                    }
                    return LOOPS;
                }
            });

            stringContainerTests.add(new Test<StringContainer>("get") {
                @Override
                int test(StringContainer container, TestParam tp) {
                    for (int i = 0; i < LOOPS; i++) {
                        container.get(i);
                    }
                    return LOOPS;
                }
            });
        }
    }


    // сравнить производительность этого контейнера с ArrayList<String>
    public static void main(String[] args) {
        Tester.defaultParams = TestParam.array(TestStringContainer.LOOPS, 1);
        Tester.run(new ArrayList<>(TestStringContainer.LOOPS), TestStringContainer.listTests);
        Tester.run(new StringContainer(TestStringContainer.LOOPS), TestStringContainer.stringContainerTests);
    }
}
