package chapters.eighteen.input_optput.serialization.ownmethods;

import java.io.*;

public class SerialCtl implements Serializable {
    private String a;
    private transient String b;

    public SerialCtl(String aa, String bb) {
        a = "Not Transient: " + aa;
        b = "Transient: " + bb;
    }

    public String toString() {
        return a + "\n" + b;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(b);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        b = (String) stream.readObject();
    }

    // test-drive
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialCtl sc = new SerialCtl("Test1", "Test2");
        System.out.println("Before:\n" + sc);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(buffer);
        out.writeObject(sc);
        // теперь получаем обратно
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
        SerialCtl sc2 = (SerialCtl) in.readObject();
        System.out.println("After:\n" + sc2);
    }
}
