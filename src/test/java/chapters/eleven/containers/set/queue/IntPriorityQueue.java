package chapters.eleven.containers.set.queue;

import java.util.*;

public class IntPriorityQueue {
     static class IntegerHolder  implements Comparable<IntegerHolder>{
        private final int randomInteger = new Random().nextInt(0, 100);

        @Override
        public int compareTo(IntegerHolder arg) {
            if (randomInteger > arg.randomInteger)
                return +1;
            if (randomInteger == arg.randomInteger) {
                return 0;
            }
            return -1;
        }

        @Override
        public String toString() {
            return Integer.toString(randomInteger);
        }
    }

    public static void main(String[] args) {
        IntegerHolder[] collection = new IntegerHolder[]{
                new IntegerHolder(),
                new IntegerHolder(),
                new IntegerHolder(),
                new IntegerHolder(),
        };
        Queue<IntegerHolder> queue = new PriorityQueue<>(List.of(collection));
        while (!queue.isEmpty()) {
            IntegerHolder poll = queue.poll();
            System.out.print(poll + " ");
        }
    }
}
