package chapters.eleven.containers.sequence;

public class SequenceTestDrive {

    public static void main(String[] args) {
        Sequence intSequence = new Sequence();
        for (int i = 0; i < 10; i++) {
            intSequence.add(Integer.toString(i));
        }

        Selector selector = intSequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }
    }
}
