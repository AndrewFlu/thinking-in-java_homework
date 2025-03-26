package chapters.eighteen.input_optput.serialization.externalizible;

import java.io.*;

public class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        System.out.println("Saving objects:");
        out.writeObject(b1);
        out.writeObject(b2);
        out.close();
        // Получаем обратно
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
        System.out.println("Recovering b1:");
        b1 = (Blip1) in.readObject();
        System.out.println("Recovering b2:");
        b2 = (Blip2) in.readObject();
    }
}
