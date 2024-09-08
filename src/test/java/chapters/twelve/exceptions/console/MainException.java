package chapters.twelve.exceptions.console;

import java.io.FileInputStream;

public class MainException {
    // передаём исключения на консоль
    public static void main(String[] args) throws Exception {
        // открываем файл
        FileInputStream inStream = new FileInputStream("unexistingfile.name");
        // используем файл

        // закрываем файл
        inStream.close();
    }
}
