package chapters.eighteen.input_optput.nio.buffers;

import chapters.fifteen.generics.strorycharacters.marvel.infinitywar.Character;
import chapters.three.CharsInBinary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BuffersToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();

        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();
        // не сработает
        System.out.println(buffer.asCharBuffer());
        // декодировать с использованием кодировки по умолчанию:
        buffer.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + ": " + Charset.forName(encoding).decode(buffer));
        // а можно использовать кодировку, пригодную для печати
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("MacBook is awesome!!!".getBytes("UTF-16BE")));
        fc.close();
        // снова пытаемся прочитать
        fc = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());

        // используем CharBuffer для записи
        fc = new FileOutputStream("data2.txt").getChannel();
        buffer = ByteBuffer.allocate(24); // more than needed
        buffer.asCharBuffer().put("Some text");
        fc.write(buffer);
        fc.close();
        // чтение и отображение
        fc = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
    }
}
