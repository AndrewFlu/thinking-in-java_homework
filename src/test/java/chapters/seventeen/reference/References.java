package chapters.seventeen.reference;

import java.lang.ref.*;
import java.util.LinkedList;

public class References {
    private static ReferenceQueue<VeryBig> referenceQueue = new ReferenceQueue<>();

    public static void checkQueue() {
        Reference<? extends VeryBig> inq = referenceQueue.poll();
        if (inq != null)
            System.out.println("In queue: " + inq.get());
    }

    public static void main(String[] args) {
        int size = 10;
        // или использовать размер, заданный в командной строке
        if (args.length > 0)
            size = Integer.parseInt(args[0]);

        // soft reference
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            sa.add(new SoftReference<>(new VeryBig("Soft " + i), referenceQueue));
            System.out.println("Just created: " + sa.getLast());
            checkQueue();
        }
        System.out.println();

        // weak reference
        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            wa.add(new WeakReference<VeryBig>(new VeryBig("Weak " + i), referenceQueue));
            System.out.println("Just created: " + wa.getLast());
            checkQueue();
        }
        System.out.println();

        SoftReference<VeryBig> s = new SoftReference<>(new VeryBig("Soft"));
        WeakReference<VeryBig> w = new WeakReference<>(new VeryBig("Weak"));
        System.gc();

        // Phantom reference
        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            pa.add(new PhantomReference<>(new VeryBig("Phantom " + i), referenceQueue));
            System.out.println("Just created: " + pa.getLast());
            checkQueue();
        }
    }
}
