package chapters.ten.multiimplementation.sequence;

public class BrandSequenceTestDrive {
    public static void main(String[] args) {
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

        Sequence sequence = brandSequence.sequenceSelector();
        String current = (String) sequence.sequenceSelector().selector().current();
        System.out.println(current);
    }
}
