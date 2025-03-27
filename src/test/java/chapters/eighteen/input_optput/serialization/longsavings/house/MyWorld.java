package chapters.eighteen.input_optput.serialization.longsavings.house;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyWorld {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        House house = new House();
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Sansa the cat", house));
        animals.add(new Animal("Djemm the cat", house));
        animals.add(new Animal("Ponchik the dog", house));
        System.out.println("Animals:\n" + animals);
        // serialization
        ByteArrayOutputStream buffer1 = new ByteArrayOutputStream();
        ObjectOutputStream out1 = new ObjectOutputStream(buffer1);
        out1.writeObject(animals);
        out1.writeObject(animals); // записываем 2-й набор
        // запись в другой поток
        ByteArrayOutputStream buffer2 = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(buffer2);
        out2.writeObject(animals);
        // deserialization
        ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buffer1.toByteArray()));
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buffer1.toByteArray()));
        List
                animals1 = (List) in1.readObject(),
                animals2 = (List) in1.readObject(),
                animals3 = (List) in2.readObject();

        System.out.println("animals1: " + animals1);
        System.out.println("animals2: " + animals2);
        System.out.println("animals3: " + animals3);
    }
}
