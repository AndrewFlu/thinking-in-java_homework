package chapters.eighteen.input_optput.serialization;

import java.io.*;

public class TableSerializationTestDrive {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // создадим объект
        Table table = new Table(new TableTop("Массив дуба"));
        // сериализуем объект (превратим его в байты)
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("table.out"));
        out.writeObject(table);
        out.close();
        // Десериализуем объект
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("table.out"));
        Table deserializedTable = (Table) in.readObject();
        in.close();

        // Проверим корректность десериализации
        System.out.println(deserializedTable);

    }
}
