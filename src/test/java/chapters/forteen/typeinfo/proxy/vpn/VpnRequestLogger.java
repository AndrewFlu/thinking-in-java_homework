package chapters.forteen.typeinfo.proxy.vpn;

import java.lang.reflect.Proxy;

public class VpnRequestLogger implements Vpn {

    private final Vpn proxied;

    public VpnRequestLogger(Vpn realVpn) {
        proxied = (Vpn) Proxy.newProxyInstance(
                VpnLogHandler.class.getClassLoader(),
                new Class[]{Vpn.class},
                new VpnLogHandler(realVpn)
        );
    }

    @Override
    public void connect() {
        proxied.connect();
    }

    @Override
    public void disconnect() {
        proxied.disconnect();
    }

    @Override
    public String getUrlInfo() {
        return proxied.getUrlInfo();
    }
}
