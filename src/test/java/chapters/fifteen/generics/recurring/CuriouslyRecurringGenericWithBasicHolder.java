package chapters.fifteen.generics.recurring;

public class CuriouslyRecurringGenericWithBasicHolder {
    public static void main(String[] args) {
        Subtype subtype1 = new Subtype();
        Subtype subtype2 = new Subtype();

        subtype1.set(subtype2);
        Subtype subtype3 = subtype1.get();
        subtype1.printClassInfo();
    }

    private static class Subtype extends BasicHolder<Subtype>{
    }
}
