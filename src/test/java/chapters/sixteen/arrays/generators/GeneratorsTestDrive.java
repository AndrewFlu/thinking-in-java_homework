package chapters.sixteen.arrays.generators;

import utils.Generator;

public class GeneratorsTestDrive {
    private static int size = 5;

    public static void main(String[] args) {
        test(CountingGenerator.class);

        System.out.println();
        System.out.println("RandomGenerator.class");
        test(RandomGenerator.class);
    }

    private static void test(Class<?> surroundingClass) {
        for (Class<?> type : surroundingClass.getClasses()) {
            System.out.print(type.getSimpleName() + ": ");

            try {
                Generator<?> generator = (Generator<?>) type.newInstance();

                for (int i = 0; i < size; i++) {
                    System.out.printf(generator.next() + " ");
                }
                System.out.println();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
