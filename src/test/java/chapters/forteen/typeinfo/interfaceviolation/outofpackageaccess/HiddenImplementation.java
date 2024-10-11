package chapters.forteen.typeinfo.interfaceviolation.outofpackageaccess;

import chapters.forteen.typeinfo.interfaceviolation.A;
import chapters.forteen.typeinfo.interfaceviolation.packageaccess.HiddenC;

import java.lang.reflect.Method;

public class HiddenImplementation {
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        a.a();
        System.out.println(a.getClass().getName());
        // Ошибка компиляции: не удаётся найти имя 'C'
        /* if (a instanceof C) {
            C c = (C)a;
            c.g();
        } */
        // Сюрприз! Отражение позволяет вызвать c()
        callHiddenMethod(a, "c");
        // и даже менее доступные методы
        callHiddenMethod(a, "d");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    static void callHiddenMethod(Object object, String methodName) throws Exception {
        Method method = object.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(object);
    }
}
