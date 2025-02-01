package chapters.eleven.containers.set.slowset;

import chapters.containers.countries.Countries;

public class SlowSetTest {
    public static void main(String[] args) {
        test(new SlowSet<>());
    }

    private static void test(SlowSet<Object> set) {
        System.out.println(set.getClass().getSimpleName());
        set.addAll(Countries.capitals());
        System.out.println(set);
        System.out.println("add new element 'Prague'...");
        set.add("Prague");
        System.out.println(set);
        System.out.println("Clear set...");
        set.clear();
        System.out.println("set is empty?: " + set.isEmpty());
    }
}
