package chapters.forteen.typeinfo.proxy.vpn;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class VpnLogHandler implements InvocationHandler {
    private Vpn proxied;

    public VpnLogHandler(Vpn proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Запись в лог запроса к серверу");

        Object invoke = method.invoke(proxied, args);
        System.out.println("log: установлено соединение с VPN по следующему URL: " + proxied.getUrlInfo());

        return invoke;
    }
}
