package chapters.eighteen.input_optput.binary;

import net.mindview.utils.BinaryFile;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class IOTask19 {
    static String file = "src/test/java/chapters/eighteen/input_optput/binary/IOTask19.java";

    public static void main(String[] args) throws IOException {
        byte[] readBytes = BinaryFile.read(file);
        Map<Byte, Integer> counter = new TreeMap<>();
        for (byte aByte : readBytes)
            counter.put(aByte, counter.containsKey(aByte) ? counter.get(aByte) + 1 : 1);
        System.out.println(counter);
    }
}
