package chapters.eighteen.input_optput.nio.buffers;

import org.w3c.dom.ls.LSOutput;

import java.nio.*;

public class ViewBuffers {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});

        bb.rewind();
        System.out.println("ByteBuffer ");
        while (bb.hasRemaining())
            System.out.println(bb.position() + " -> " + bb.get() + ", ");
        System.out.println();

        CharBuffer cb = bb.rewind().asCharBuffer();
        System.out.println("CharBuffer ");
        while (cb.hasRemaining())
            System.out.println(cb.position() + " -> " + cb.get() + ", ");
        System.out.println();

        FloatBuffer fb = bb.rewind().asFloatBuffer();
        System.out.println("FloatBuffer ");
        while (fb.hasRemaining())
            System.out.println(fb.position() + " -> " + fb.get() + ", ");
        System.out.println();

        IntBuffer ib = bb.rewind().asIntBuffer();
        System.out.println("IntBuffer ");
        while (ib.hasRemaining())
            System.out.println(ib.position() + " -> " + ib.get() + ", ");
        System.out.println();

        LongBuffer lb = bb.rewind().asLongBuffer();
        System.out.println("LongBuffer ");
        while (lb.hasRemaining())
            System.out.println(lb.position() + " -> " + lb.get() + ", ");
        System.out.println();

        ShortBuffer sb = bb.rewind().asShortBuffer();
        System.out.println("ShortBuffer ");
        while (sb.hasRemaining())
            System.out.println(sb.position() + " -> " + sb.get() + ", ");
        System.out.println();

        DoubleBuffer db = bb.rewind().asDoubleBuffer();
        System.out.println("DoubleBuffer ");
        while (db.hasRemaining())
            System.out.println(db.position() + " -> " + db.get() + ", ");
        System.out.println();
    }
}
