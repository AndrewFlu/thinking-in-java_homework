package chapters.eighteen.input_optput.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.SortedSet;

public class SortedDirList {
    private final File path;

    public SortedDirList(String path) {
        this.path = new File(path);
    }

    public String[] list() {
        String[] list = path.list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }

    public String[] list(final String regex) {
        String[] list = path.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches(regex);
            }
        });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }

    public static void main(String[] args) {
        SortedDirList sortedList = new SortedDirList(".");
        System.out.println(Arrays.toString(sortedList.list(".*.xml")));
    }
}
