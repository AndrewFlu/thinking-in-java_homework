package chapters.eleven.containers.deque;

public class DequeTest {

    private static void fillTest(Deque<Integer> deque) {
        for (int i = 20; i < 27; i++) {
            deque.addFirst(i);
        }
        for (int i = 50; i < 57; i++) {
            deque.addLast(i);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> di = new Deque<>();
        fillTest(di);
        System.out.println(di);
        while (di.size() != 0) {
            System.out.print(di.removeLast() + " ");
        }
    }
}
