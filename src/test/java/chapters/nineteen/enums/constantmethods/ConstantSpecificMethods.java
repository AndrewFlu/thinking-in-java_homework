package chapters.nineteen.enums.constantmethods;

import java.text.DateFormat;
import java.util.Date;

public enum ConstantSpecificMethods {
    DATE_TIME{
        @Override
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        @Override
        String getInfo() {
            return System.getenv("HOME");
        }
    },
    VERSION {
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    },
    ;
    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethods m : values())
            System.out.println(m.getInfo());
    }
}
