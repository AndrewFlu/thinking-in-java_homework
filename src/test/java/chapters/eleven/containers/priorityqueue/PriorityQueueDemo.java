package chapters.eleven.containers.priorityqueue;

import chapters.eleven.containers.queue.QueueDemo;

import java.util.*;

import static chapters.eleven.containers.queue.QueueDemo.printQ;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // random integers
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            priorityQueue.offer(random.nextInt(i + 10));
        }
        System.out.println("priorityQueue: ");
        printQ(priorityQueue);

        // duplicate unordered integers
        List<Integer> ints = Arrays.asList(10, 15, 2, 1, 1, 5, 44, 21, 8, 17, 15);
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>(ints);
        System.out.println("integerPriorityQueue: ");
        printQ(integerPriorityQueue);

        // reverse order
        PriorityQueue<Integer> reversePq = new PriorityQueue<>(ints.size(), Collections.reverseOrder());
        reversePq.addAll(ints);
        System.out.println("reversePq: ");
        printQ(reversePq);

        // queue from string
        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringsPq = new PriorityQueue<>(strings);
        System.out.println("stringsPq: ");
        printQ(stringsPq);

        // reverse strings queue
        PriorityQueue<String> stringReversePq = new PriorityQueue<>(strings.size(), Collections.reverseOrder());
        stringReversePq.addAll(strings);
        System.out.println("stringReversePq: ");
        printQ(stringReversePq);

        // characters queue
        Set<Character> charSet = new HashSet<>();
        for (Character c : fact.toCharArray()) {
            charSet.add(c);
        }
        PriorityQueue<Character> charactersPq = new PriorityQueue<>(charSet);
        System.out.println("charactersPq: ");
        printQ(charactersPq);
    }
}
