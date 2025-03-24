package chapters.eighteen.input_optput.nio.buffers;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IntBufferDemo {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer intBuffer = bb.asIntBuffer();
        // сохраняем массив целых чисел:
        intBuffer.put(new int[]{11, 42, 47, 99, 143, 811, 1016});
        // чтение и запись по абсолютным позициям:
        System.out.println("int[3] = " + intBuffer.get(3));
        System.out.println();
        intBuffer.put(3, 1811);
        //  установление нового предела перед началом к возврату буфера:
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            int i = intBuffer.get();
            System.out.println(i);
        }
    }
}
