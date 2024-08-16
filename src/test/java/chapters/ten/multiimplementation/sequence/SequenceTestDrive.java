package chapters.ten.multiimplementation.sequence;

public class SequenceTestDrive {

    public static void main(String[] args) {
        Sequence intSequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            intSequence.add(Integer.toString(i));
        }

        System.out.println("Forward Selector:");
        Selector selector = intSequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }

        System.out.println("Reverse Selector:");
        Selector reverseSelector = intSequence.reverseSelector();
        while(!reverseSelector.end()) {
            System.out.println(reverseSelector.current() + " ");
            reverseSelector.next();
        }
    }
}
