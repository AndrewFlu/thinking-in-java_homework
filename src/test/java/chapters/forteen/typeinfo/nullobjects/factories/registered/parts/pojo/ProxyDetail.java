package chapters.forteen.typeinfo.nullobjects.factories.registered.parts.pojo;

import chapters.forteen.typeinfo.nullobjects.factories.registered.parts.Detail;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyDetail extends Detail implements InvocationHandler {
    private String name;
    private Detail realDetail;

    public ProxyDetail(Detail realDetail) {
        this.realDetail = realDetail;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Здесь должна быть деталь: " + name);
        Object invoke = method.invoke(realDetail, args);
        System.out.println("Вызов метода в Proxy-объекте завершён");
        return invoke;
    }
}
