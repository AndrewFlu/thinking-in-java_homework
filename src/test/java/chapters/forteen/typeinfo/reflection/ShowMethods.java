package chapters.forteen.typeinfo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import static net.mindview.utils.Print.print;

public class ShowMethods {
    private static String usage = "usage: \n" +
            "ShowMethods Qualified.class.name\n" +
            "To show all methods in class or:\n" +
            "ShowMethods Qualified.class.name word\n" +
            "To search for methods involving 'word'";

//    private static final Pattern pattern = Pattern.compile("\\w+\\.");

    // регулярное выражение, чтобы в названиях методов не было: final, native и имен пакетов
    private static final Pattern pattern = Pattern.compile("native\\s+|final\\s+|\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            print(usage);
            System.exit(0);
        }

        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);

            Method[] methods = c.getMethods();
            Constructor<?>[] constructors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    print(pattern.matcher(method.toString()).replaceAll(""));
                }
                for (Constructor ctor : constructors) {
                    print(pattern.matcher(ctor.toString()).replaceAll(""));
                }
                lines = methods.length + constructors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().indexOf(args[1]) != -1) {
                        print(pattern.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                }
                for (Constructor ctor : constructors) {
                    if (ctor.toString().indexOf(args[1]) != -1) {
                        print(pattern.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            print("No such class: " + e);
        }
    }
}
