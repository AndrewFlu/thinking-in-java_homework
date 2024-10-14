package chapters.fifteen.generics.tuples.sequence;

public class SequenceTestDrive {

    public static void main(String[] args) {
        Sequence<Integer> intSequence = new Sequence<>(10);
        for (int i = 0; i < 10; i++) {
            intSequence.add(i);
        }

        Selector<Integer> selector = intSequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current() + " ");
            selector.next();
        }
        // brands
        Sequence<Brand> brandSequence = new Sequence<Brand>(3);
        brandSequence.add(new Brand("Audi"));
        brandSequence.add(new Brand("BMW"));
        brandSequence.add(new Brand("Mersedes"));

        Selector<Brand> brandSelector = brandSequence.selector();
        while (!brandSelector.end()){
            System.out.println(brandSelector.current() + " ");
            brandSelector.next();
        }

        Sequence<Brand> sequence = brandSequence.sequenceSelector();
        Brand current = sequence.sequenceSelector().selector().current();
        System.out.println(current);
    }
}
