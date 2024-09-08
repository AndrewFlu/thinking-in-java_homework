package chapters.thirteen.strings.recursion;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {
    @Override
    public String toString() {
        return "Address of class InfiniteRecursion is: " + super.toString();
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> recursions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            recursions.add(new InfiniteRecursion());
        }

        System.out.println(recursions);
    }
}
