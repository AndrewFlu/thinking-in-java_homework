package chapters.forteen.typeinfo.reflection.packageaccess.powerfullreflection;

import chapters.forteen.typeinfo.reflection.packageaccess.library.Human;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static chapters.forteen.typeinfo.reflection.packageaccess.powerfullreflection.PowerAccessibleReflection.callHiddenMethod;

public class ReflectionGetTotalAccessTestDrive {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        Human zhenyok = new Human("Женёчек", 300_000);
        zhenyok.sayName();
        // reflection has total access over target class
        List<Method> methods = Arrays.stream(zhenyok.getClass().getDeclaredMethods()).toList();
        methods.forEach(System.out::println);
        callHiddenMethod(zhenyok, "saySalary");
        callHiddenMethod(zhenyok, "takeCar");
        callHiddenMethod(zhenyok, "sayCountry");

        changeSalary(zhenyok, 100_000);
        callHiddenMethod(zhenyok, "saySalary");

    }

    private static void changeSalary(Human zhenyok, int targetSalary) throws NoSuchFieldException, IllegalAccessException {
        System.out.println("trying to change a salary...");
        Field salary = zhenyok.getClass().getDeclaredField("salary");
        salary.setAccessible(true);
        salary.setInt(zhenyok, targetSalary);
    }
}
