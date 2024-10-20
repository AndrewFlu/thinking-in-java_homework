package chapters.fifteen.generics.generators;

import utils.Generator;

public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> generator = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }
    }

    public static class CountedObject {
        private static int count;
        private final int id = count++;

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "CountedObject{" +
                    "id=" + id +
                    '}';
        }
    }
}
