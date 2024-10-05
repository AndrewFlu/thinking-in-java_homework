package chapters.forteen.typeinfo.proxy.simpledinamicproxy;

import chapters.forteen.typeinfo.proxy.simpleproxy.Interface;
import chapters.forteen.typeinfo.proxy.simpleproxy.RealObject;

import java.lang.reflect.Proxy;

public class SimpleDynamicProxy {
    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // Insert a proxy and run again
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(real)
        );
        consumer(proxy);
    }

    private static void consumer(Interface iFace) {
        iFace.doSomething();
        iFace.somethingElse("boooo!");
    }
}
