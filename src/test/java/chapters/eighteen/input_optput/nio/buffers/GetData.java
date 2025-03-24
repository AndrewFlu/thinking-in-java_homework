package chapters.eighteen.input_optput.nio.buffers;

import java.nio.ByteBuffer;

import static net.midview.Print.print;

public class GetData {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
        // При выделении буфер автоматически заполняется нулями
        int i = 0;
        System.out.println("buffer size: " + byteBuffer.array().length);
        while (i++ < byteBuffer.limit())
            if (byteBuffer.get() != 0)
                print("nonzero");
        print("i = " + i);
        byteBuffer.rewind();
        // Сохраняем и читаем символьный массив
        byteBuffer.asCharBuffer().put("Howdy!");
        char c;
        while ((c = byteBuffer.getChar()) != 0)
            System.out.print(c + " ");
        System.out.println();
        byteBuffer.rewind();

        // Сохраняем и читаем число типа short:
        byteBuffer.asShortBuffer().put((short)471142);
        System.out.println("short: " + byteBuffer.getShort());
        byteBuffer.rewind();

        //  Сохраняем и читаем число типа int:
        byteBuffer.asIntBuffer().put(99471142);
        System.out.println("int: " + byteBuffer.getInt());
        byteBuffer.rewind();

        // Сохраняем и читаем число тип long;
        byteBuffer.asLongBuffer().put(99471142);
        System.out.println("long: " + byteBuffer.getLong());
        byteBuffer.rewind();

        // Сохраняем и читаем число тпа float:
        byteBuffer.asFloatBuffer().put(99471142);
        System.out.println("float: " + byteBuffer.getFloat());
        byteBuffer.rewind();

        // Сохраняем и читаем число типа double:
        byteBuffer.asDoubleBuffer().put(99471142);
        System.out.println("double: " + byteBuffer.getDouble());
        byteBuffer.rewind();
    }
}
