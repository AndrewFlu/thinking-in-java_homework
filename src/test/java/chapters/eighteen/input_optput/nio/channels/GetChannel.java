package chapters.eighteen.input_optput.nio.channels;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {

        // Запись файла
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));;
        fc.close();

        // Добавление в конец файла
        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        fc.position(fc.size()); // перемещение в конец
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();

        // Чтение файла
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
        while (buff.hasRemaining())
            System.out.print((char) buff.get());
    }
}
