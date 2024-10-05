package chapters.forteen.typeinfo.reflection.classInfo;

import java.util.Arrays;
import java.util.regex.Pattern;

import static net.midview.Print.print;

public class ClassInfo {
    private static String usage = "Usage:\n" +
            "ClassInfo Qualified.class.name\n" +
            "To show all information about specified class";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(usage);
            System.exit(1);
        }

        try {
            Class<?> aClass = Class.forName(args[0]);
            System.out.println(String.format("Класс [%s] имеет следующие свойства", aClass.getName()));

            printInfo("Методы: ", aClass.getMethods());
            printInfo("Заявленные методы: ", aClass.getDeclaredMethods());

            printInfo("Конструкторы:", aClass.getConstructors());
            printInfo("Заявленные конструкторы:", aClass.getDeclaredConstructors());

            print("Является синтетическим: " + aClass.isSynthetic());
            print("Является примитивом: " + aClass.isPrimitive());
            print("Является членом класса: " + aClass.isMemberClass());
            print("Является локальным классом: " + aClass.isLocalClass());
            print("Является интерфейсом: " + aClass.isInterface());
            print("Домен защиты: " + aClass.getProtectionDomain());
            print("Загрузчик класса: " + aClass.getClassLoader());
            print("Закрывающий класс: " + aClass.getEnclosingClass());
            print("Базовый класс: " + aClass.getSuperclass());

        } catch (ClassNotFoundException e) {
            System.out.println("Cannot managed to find a class: " + e);
        }
    }

    private static void printInfo(String name, Object[] array) {
        Pattern p = Pattern.compile("\\w+\\.");
        System.out.println(name);
        Arrays.stream(array)
                .map(el -> p.matcher(el.toString()).replaceAll(""))
                .map(el -> "\t" + el)
                .forEach(System.out::println);
    }
}
