package chapters.eighteen.input_optput.file;

import net.mindview.utils.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class DirList4 {
    public static void main(final String[] args) {
        File path = new File("./src/test/java/chapters/eighteen/input_optput/file/");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else
            list = path.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    TextFile textFile = new TextFile(name, "\\W+");
                    return !textFile.isEmpty();
                }
            });
        if (list.length > 0) {
            Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
            System.out.println(Arrays.toString(list));

            long totalSpace = 0;
            for (String fileName : list) {
                totalSpace += new File(path, fileName).length();
            }

            System.out.println(String.format("Total space = %d bytes", totalSpace));
        }
    }
}
