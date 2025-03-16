package chapters.eighteen.input_optput.directory;

import net.mindview.utils.Directory;
import net.mindview.utils.PPrint;

import java.io.File;

import static net.midview.Print.print;

public class DirectoryDemo {

    public static final String PATH = "./src/test/java/chapters/eighteen/";

    public static void main(String[] args) {
        // Все каталоги
        PPrint.pprint(Directory.walk(PATH).dirs);
        // Все файлы, имена которых начинаются с 'D'
        for (File file : Directory.local(PATH, "D.*"))
            System.out.println(file);
        print("----------------------");

        // Все файлы Java, имена которых начинаются с "D"
        for (File file : Directory.walk(PATH, "[Dd].*\\.java"))
            System.out.println(file);
        print("======================");

        // Файлы классов, имена которых содержат "Z" или "z"
        for (File file : Directory.walk(PATH, ".*[Zz].*\\.class"))
            System.out.println(file);
    }
}
