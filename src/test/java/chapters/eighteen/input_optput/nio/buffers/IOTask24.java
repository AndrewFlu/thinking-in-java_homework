package chapters.eighteen.input_optput.nio.buffers;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;

public class IOTask24 {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer doubleBuffer = bb.asDoubleBuffer();
        // сохраняем массив целых чисел:
        doubleBuffer.put(new double[]{11.1, 42.2, 47.7, 99, 143, 811, 1016});
        // чтение и запись по абсолютным позициям:
        System.out.println("double[3] = " + doubleBuffer.get(3));
        System.out.println();
        doubleBuffer.put(3, 1811);
        //  установление нового предела перед началом к возврату буфера:
        doubleBuffer.flip();
        while (doubleBuffer.hasRemaining()) {
            double i = doubleBuffer.get();
            System.out.println(i);
        }
    }
}
