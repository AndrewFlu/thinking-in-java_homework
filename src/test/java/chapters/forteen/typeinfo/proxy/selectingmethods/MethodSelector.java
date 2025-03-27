package chapters.forteen.typeinfo.proxy.selectingmethods;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static net.mindview.utils.Print.print;

public class MethodSelector implements InvocationHandler {
    private final Object proxied;

    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("interesting")) {
            print("Proxy detected the interesting method");
        }

        return method.invoke(proxied, args);
    }
}
