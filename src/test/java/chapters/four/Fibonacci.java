package chapters.four;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public static List generate(int limit) {
        List<Integer> fibonacci = new ArrayList<>(limit);
        int initiateCapacity = 2;
        initiateFibonacci(fibonacci, initiateCapacity);
        for (int i = 1; i <= limit - initiateCapacity; i++) {
            fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i));
        }
        return fibonacci;
    }

    private static void initiateFibonacci(List<Integer> fibonacci, int capacity) {
        fibonacci.add(0);
        fibonacci.add(1);
        for (int i = 1; i < capacity; i++) {
            fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i));
        }
        fibonacci.removeFirst();
    }

    public static void main(String[] args) {
        System.out.println(generate(Integer.parseInt(args[0])));
    }
}