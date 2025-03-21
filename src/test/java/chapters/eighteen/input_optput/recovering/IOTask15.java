package chapters.eighteen.input_optput.recovering;

import java.io.*;

public class IOTask15 {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("AllTypes.txt")));

        out.writeByte(5);
        out.writeUTF("That was byte");

        out.writeBytes("bytes");
        out.writeUTF("That was bytes");

        out.writeBoolean(true);
        out.writeUTF("That was boolean");

        out.writeChar('a');
        out.writeUTF("That was char");

        out.writeChars("MacBook");
        out.writeUTF("That was chars");

        out.writeShort(8);
        out.writeUTF("That was short");

        out.writeInt(32);
        out.writeUTF("That was int");

        out.writeLong(64);
        out.writeUTF("That was long");

        out.writeFloat(1.5F);
        out.writeUTF("That was float");

        out.writeDouble(3.14);
        out.writeUTF("That was double");

        out.write(1);
        out.writeUTF("That was write(int)");

        out.write(new byte[]{1, 2, 3, 4, 5});
        out.writeUTF("That was write(byte[])");

        out.close();

        DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream("AllTypes.txt")));
        System.out.println(in.readByte());
        System.out.println(in.readUTF());

        // bytes — 5 bytes
        System.out.println(in.readByte());
        System.out.println(in.readByte());
        System.out.println(in.readByte());
        System.out.println(in.readByte());
        System.out.println(in.readByte());
        System.out.println(in.readUTF());

        System.out.println(in.readBoolean());
        System.out.println(in.readUTF());

        System.out.println(in.readChar());
        System.out.println(in.readUTF());

        // MacBook - 7 chars
        System.out.println(in.readChar());
        System.out.println(in.readChar());
        System.out.println(in.readChar());
        System.out.println(in.readChar());
        System.out.println(in.readChar());
        System.out.println(in.readChar());
        System.out.println(in.readChar());
        System.out.println(in.readUTF());

        System.out.println(in.readShort());
        System.out.println(in.readUTF());

        System.out.println(in.readInt());
        System.out.println(in.readUTF());

        System.out.println(in.readLong());
        System.out.println(in.readUTF());

        System.out.println(in.readFloat());
        System.out.println(in.readUTF());

        System.out.println(in.readDouble());
        System.out.println(in.readUTF());

        System.out.println(in.read());
        System.out.println(in.readUTF());

        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.read());
        System.out.println(in.readUTF());


    }
}
