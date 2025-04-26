package net.mindview.atunit;

import net.mindview.utils.BinaryFile;
import net.mindview.utils.Directory;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static net.mindview.utils.Print.print;

public class ClassNameFinder {
    public static String thisClass(byte[] classBytes) {
        Map<Integer, Integer> offsetTable = new HashMap<>();
        Map<Integer, String> classNameTable = new HashMap<>();
        try {
            DataInputStream data = new DataInputStream(
                    new ByteArrayInputStream(classBytes));
            int magic = data.readInt();
            int minorVersion = data.readShort();
            int majorVersion = data.readShort();
            int constant_pool_count = data.readShort();
            int[] constant_pool = new int[constant_pool_count];
            for (int i = 1; i < constant_pool_count; i++) {
                int tag = data.read();
                int tableSize;
                switch (tag) {
                    case 1: // UTF
                        int length = data.readShort();
                        char[] bytes = new char[length];
                        for (int j = 0; j < bytes.length; j++) {
                            bytes[j] = (char) data.read();
                        }
                        String className = new String(bytes);
                        classNameTable.put(i, className);
                        break;
                    case 5: // LONG
                    case 6: // DOUBLE
                        data.readLong(); // отбросить 8 байт
                        i++; // Необходим дополнительный пропуск
                        break;
                    case 7: // CLASS
                        int offset = data.readShort();
                        offsetTable.put(i, offset);
                        break;
                    case 8: // STRING
                        data.readShort();
                        break;
                    case 3: // INTEGER
                    case 4: // FLOAT
                    case 9: // FIELD_REF
                    case 10: // METHOD_REF
                    case 11: // INTERFACE_MEtHOD_REF
                    case 12: // NAME_AND_TYPE
                        data.readInt(); // Отбросить 4 байта
                        break;
                    default:
                        throw new RuntimeException("Bad tag " + tag);
                }
            }
            short access_flags = data.readShort();
            int this_class = data.readShort();
            return classNameTable.get(this_class).replace('/', '.');
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            for (String arg : args)
                print(thisClass(BinaryFile.read(new File(arg))));
        } else
            // Обход всего дерева
            for (File clazz : Directory.walk(".", ".*\\.class"))
                print(thisClass(BinaryFile.read(clazz)));
    }
}
