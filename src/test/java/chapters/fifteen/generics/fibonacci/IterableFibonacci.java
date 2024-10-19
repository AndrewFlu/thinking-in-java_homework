package chapters.fifteen.generics.fibonacci;

import java.util.Iterator;

public class IterableFibonacci implements Iterable<Integer>{
    private int n;
    private final FibonacciGenerator fibonacciGenerator;

    public IterableFibonacci(int count) {
        this.n = count;
        fibonacciGenerator = new FibonacciGenerator();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return fibonacciGenerator.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // test-drive
        public static void main(String[] args) {
            for (int i : new IterableFibonacci(18)) {
                System.out.print(i + " ");
            }
        }
}
