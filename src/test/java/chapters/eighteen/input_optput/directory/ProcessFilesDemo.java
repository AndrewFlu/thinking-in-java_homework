package chapters.eighteen.input_optput.directory;

import net.mindview.utils.ProcessFiles;

import java.io.File;

public class ProcessFilesDemo {
    public static void main(String[] args) {
        new ProcessFiles(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, "java").start(args);
    }
}
