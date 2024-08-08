package chapters.ten.sequence;

public class SequenceTestDrive {

    public static void main(String[] args) {
        Sequence intSequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            intSequence.add(Integer.toString(i));
        }

        Selector selector = intSequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }
        // brands
        Sequence brandSequence = new Sequence(3);
        brandSequence.add("Audi");
        brandSequence.add("BMW");
        brandSequence.add("Mersedes");

        Selector brandSelector = brandSequence.selector();
        while (!brandSelector.end()){
            System.out.println(brandSelector.current() + " ");
            brandSelector.next();
        }

    }
}
