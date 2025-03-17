package chapters.eighteen.input_optput.file;

import net.mindview.utils.ProcessFiles;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class FindChangedSourcesAfterDate {
    private final ProcessFiles processFiles;

    public FindChangedSourcesAfterDate(Date changedAfterthisDate) {
        this.processFiles = new ProcessFiles(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                if (file.lastModified() > changedAfterthisDate.getTime())
                    System.out.println(file.getName());
            }
        }, ".*\\.java");
    }

    public ProcessFiles getProcess() {
        return processFiles;
    }

    public static void main(String[] args) {
        Calendar currentDate = Calendar.getInstance();
        currentDate.add(Calendar.HOUR_OF_DAY, - 1);
        FindChangedSourcesAfterDate changedSources = new FindChangedSourcesAfterDate(currentDate.getTime());
        changedSources.getProcess().start(args);
    }
}
