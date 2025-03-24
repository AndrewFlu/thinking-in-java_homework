package chapters.eighteen.input_optput.nio.buffers;

import java.nio.CharBuffer;

import static net.midview.Print.print;

public class IOTask23 {
    public static void main(String[] args) {
        char[] ca = {'w', 'x', 'y', 'z'};
        CharBuffer cb = CharBuffer.wrap(ca);
        print("CharBuffer by wrapping char[]: ");
        printCharBuffer(cb);
        System.out.println();
        CharBuffer cb2 = CharBuffer.allocate(6);
        char[] ca2 = {'s', 't', 'u', 'v', 'w'};
        cb2.put(ca2);
        print("CharBuffer by allocation: ");
        printCharBuffer(cb2);

        // try some unprintable chars:
        char[] ca3 = {(char)0x07, (char)0x7f, 'b', 'y', 'e'};
        CharBuffer cb3 = CharBuffer.wrap(ca3);
        print("CharBuffer including some unprintables: ");
        printCharBuffer(cb3);
     }

    private static void printCharBuffer(CharBuffer charBuffer) {
        charBuffer.clear(); // sets position to zero, limit to capacity
        while (charBuffer.hasRemaining()) {
            char c = charBuffer.get();
            if (isPrintable(c))
                System.out.print(c);
        }
    }

    private static boolean isPrintable(char c) {
        return (c >= '!') && (c <= '~');
    }
}
