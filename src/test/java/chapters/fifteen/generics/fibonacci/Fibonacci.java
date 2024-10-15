package chapters.fifteen.generics.fibonacci;

import utils.Generator;

public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    private int getFibonacciNumber(int n) {
        if (n < 2) return 1;

        return getFibonacciNumber(n - 2) + getFibonacciNumber(n - 1);
    }

    @Override
    public Integer next() {
        return getFibonacciNumber(count++);
    }

    // test-drive
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 20; i++) {
            System.out.println(fibonacci.next());
        }
    }
}
