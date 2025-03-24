package chapters.eighteen.input_optput.nio.buffers;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

public class AvailableCharSets {
    public static void main(String[] args) {
        SortedMap<String, Charset> charSets = Charset.availableCharsets();
        Iterator<String> iterator = charSets.keySet().iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.print(next);
            Iterator aliases = charSets.get(next).aliases().iterator();
            if (aliases.hasNext())
                System.out.print(": ");
            while (aliases.hasNext()) {
                System.out.print(aliases.next());
                if (aliases.hasNext())
                    System.out.print(", ");
            }
            System.out.println();
        }
    }
}
