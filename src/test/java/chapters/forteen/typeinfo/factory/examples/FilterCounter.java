package chapters.forteen.typeinfo.factory.examples;

import utils.TypeCounter;

public class FilterCounter {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Part.class);
        for (Part part : Part.createArray(10)) {
            System.out.print(part.getClass().getSimpleName() + " ");
            counter.count(part);
        }

        System.out.println();
        System.out.println(counter);
    }
}
