package chapters.forteen.typeinfo.reflection.packageaccess.powerfullreflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PowerAccessibleReflection {
    public static void callHiddenMethod(Object obj, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = obj.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(obj);
    }
}
