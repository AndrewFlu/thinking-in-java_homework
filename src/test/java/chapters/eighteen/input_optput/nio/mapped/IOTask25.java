package chapters.eighteen.input_optput.nio.mapped;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import static net.midview.Print.print;

public class IOTask25 {
    public static File toDirect(File f) throws IOException {
        FileChannel fc = new FileInputStream(f).getChannel();
        ByteBuffer bb = ByteBuffer.allocateDirect((int) f.length());
        fc.read(bb);
        bb.flip();
        Charset defaultCharset = Charset.defaultCharset();
        CharBuffer decoded = defaultCharset.decode(bb);
        String replaced = decoded.toString().replace(".allocate(", ".allocateDirect(");
        String replacedDirect = replaced.replace(f.getName().split("\\.")[0], f.getName().split("\\.")[0] + "Direct");
        CharBuffer decodedNew = CharBuffer.wrap(replacedDirect);
        String ext = f.getName().split("\\.")[1];
        String outFile = f.getName().split("\\.")[0] + "Direct." + ext;
        FileChannel fcOut = new FileOutputStream(new File(outFile)).getChannel();
        fcOut.write(defaultCharset.encode(decodedNew));
//        fc.transferTo(0, f.length(), fcOut);
        fc.close();
        fcOut.close();

        return new File(outFile);
    }

    public static void Tester(String name) {
        try {
            // Uses reflection to call main methods
            Class<?> c = Class.forName(name);
            String className = c.getSimpleName();
            System.out.println("Testing: " + name);
            Method method = c.getMethod("main", String[].class);
            // to test ChannelCopy.class
            String[] sa = new String[]{"ChannelCopy.java", "Test.txt"};
            long start = System.nanoTime();
            method.invoke(c.newInstance(), (Object)sa);
            double duration = System.nanoTime() - start;
            System.out.println("\nTime to run " + name + " = " + duration + " nanoseconds");

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace(System.err);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static long allocationTime(int i) {
        long start = System.nanoTime();
        ByteBuffer.allocate(i);

        return System.nanoTime() - start;
    }

    public static long directAllocationTime(int i) {
        long start = System.nanoTime();
        ByteBuffer.allocateDirect(i);

        return System.nanoTime() - start;
    }

    public static void main(final String[] args) throws IOException {
        // allocation time related to startup time
        // allocation time related to startup time:
        print("Time to allocate 1024 bytes = "
                + allocationTime(1024) + " nanoseconds");
        print("Time to allocateDirect 1024 bytes = "
                + directAllocationTime(1024) + " nanoseconds");
        print("Time to allocate 48 bytes = "
                + allocationTime(48) + " nanoseconds");
        print("Time to allocateDirect 48 bytes = "
                + directAllocationTime(48) + " nanoseconds");
        print("Time to allocate 1 byte = "
                + allocationTime(1) + " nanoseconds");
        print("Time to allocateDirect 1 byte = "
                + directAllocationTime(1) + " nanoseconds");
        Tester("GetChannel");
        toDirect(new File("GetChannel.java"));
        // after compiling GetChannelDirect:
        Tester("GetChannelDirect");
        Tester("BufferToText");
        toDirect(new File("BufferToText.java"));
        // after compiling BufferToText.java:
        Tester("BufferToTextDirect");
        Tester("ChannelCopy");
        toDirect(new File("ChannelCopy.java"));
        // after compiling ChannelCopyDirect.java:
        Tester("ChannelCopyDirect");
        Tester("GetData");
        toDirect(new File("GetData.java"));
        // after compiling GetDataDirect.java:
        Tester("GetDataDirect");
        Tester("IntBufferDemo");
        toDirect(new File("IntBufferDemo.java"));
        // after compiling IntBufferDemoDirect.java:
        Tester("IntBufferDemoDirect");
        Tester("UsingBuffers");
        toDirect(new File("UsingBuffers.java"));
        // after compiling UsingBuffersDirect.java:
        Tester("UsingBuffersDirect");
    }
}
