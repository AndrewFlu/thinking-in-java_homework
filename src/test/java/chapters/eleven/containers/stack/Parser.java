package chapters.eleven.containers.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Parser {

    public static void parse(String string) {
        Stack<String> stack = new Stack<>();

        String[] symbols = string.split("");
        List<String> list = new ArrayList<>(Arrays.asList(symbols));
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("+".equals(next)) {
                stack.push(iterator.next());
            } else if ("-".equals(next)) {
                System.out.println(stack.peek());
            }
        }
    }
}
