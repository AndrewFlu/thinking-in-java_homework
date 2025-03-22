package chapters.eighteen.input_optput.randomaccess;

import java.io.IOException;
import java.io.RandomAccessFile;

public class IOTask16 {
    static String file = "rtest.dat";

    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");

        // boolean
        System.out.println(rf.readBoolean());
        System.out.println(rf.readUTF());

        // byte
        System.out.println(rf.readByte());
        System.out.println(rf.readUTF());

        // char
        System.out.println(rf.readChar());
        System.out.println(rf.readUTF());

        // short
        System.out.println(rf.readShort());
        System.out.println(rf.readUTF());

        // int
        System.out.println(rf.readInt());
        System.out.println(rf.readUTF());

        // long
        System.out.println(rf.readLong());
        System.out.println(rf.readUTF());

        // float
        System.out.println(rf.readFloat());
        System.out.println(rf.readUTF());

        // double
        System.out.println(rf.readDouble());
        System.out.println(rf.readUTF());

        // write()
        System.out.println(rf.read());
        System.out.println(rf.readUTF());

        // bytes[2]
        System.out.print((char) rf.readByte());
        System.out.print((char) rf.readByte());
        System.out.println();
        System.out.println(rf.readUTF());

        System.out.println();
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");

        // boolean
        rf.writeBoolean(true);
        rf.writeUTF("It was boolean");

        // byte
        rf.writeByte(1);
        rf.writeUTF("It was byte");

        // char
        rf.writeChar('a');
        rf.writeUTF("It was char");

        // short
        rf.writeShort(2);
        rf.writeUTF("It was short");

        // int
        rf.writeInt(3);
        rf.writeUTF("It was int");

        // long
        rf.writeLong(4);
        rf.writeUTF("It was long");

        // float
        rf.writeFloat(5.0F);
        rf.writeUTF("It was float");

        // double
        rf.writeDouble(6.0);
        rf.writeUTF("It was double");

        // plain write
        rf.write(7);
        rf.writeUTF("It was plain write()");

        // bytes[2]
        rf.writeBytes("Hi");
        rf.writeUTF("It was bytes[2]");


        rf.writeUTF("The end of the file");
        rf.close();

        display();
    }
}
