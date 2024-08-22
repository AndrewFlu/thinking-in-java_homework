package chapters.eleven.containers.list.iterator.sequence;

public class SequenceTestDrive {

    public static void main(String[] args) {
        Sequence intSequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            intSequence.add(Integer.toString(i));
        }

        while (!intSequence.end()) {
            System.out.println(intSequence.current() + " ");
        }
    }
}
