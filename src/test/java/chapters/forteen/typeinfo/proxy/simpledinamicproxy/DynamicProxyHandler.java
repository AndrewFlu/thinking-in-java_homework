package chapters.forteen.typeinfo.proxy.simpledinamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.LocalTime;

import static net.mindview.utils.Print.print;

public class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("*** proxy: " + proxy.getClass() +
//                ", method: " + method + ", args: " + args);
//        if (args != null) {
//            for (Object arg : args) {
//                System.out.println(" " + arg);
//            }
//        }
        print("Время вызова метода [" + method.getName() + "]: " + LocalTime.now());

        return method.invoke(proxied, args);
    }
}
