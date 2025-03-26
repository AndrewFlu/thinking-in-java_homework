package chapters.eighteen.input_optput.serialization.externalizible;

import java.io.*;

public class Blip3 implements Externalizable {
    private int i;
    private String s; //  инициализация не проводится

    public Blip3() {
        System.out.println("Blip3 Constructor (default)");
        // ни i, ни s не инициализируются
    }

    public Blip3(String x, int a) {
        System.out.println("Blip3(String x, int a)");
        s = x;
        i = a;
        // s и i инициализируются только в конструкторе, не являющемся конструктором по умолчанию
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal()");
        // обязательные действия (иначе будут проинициализирвоаны дефолтные значения класса (null для s и 0 для i))
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.writeExternal()");
        // обязательные действия (иначе будут проинициализирвоаны дефолтные значения класса (null для s и 0 для i))
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects");
        Blip3 b3 = new Blip3("A String ", 155);
        System.out.println(b3);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
        System.out.println("Saving object:");
        out.writeObject(b3);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
        System.out.println("Recovering b3:");
        b3 = (Blip3) in.readObject();
        System.out.println(b3);
    }
}
