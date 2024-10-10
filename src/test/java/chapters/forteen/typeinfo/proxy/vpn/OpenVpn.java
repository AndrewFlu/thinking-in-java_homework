package chapters.forteen.typeinfo.proxy.vpn;

public class OpenVpn extends AbstractVpn {

    public OpenVpn(String url) {
        super(url);
        vpnName = "OpenVPN";
    }

    @Override
    public void connect() {
        System.out.println("Установлено соединение " + vpnName);
    }

    @Override
    public void disconnect() {
        System.out.println("Соединение " + vpnName + " разорвано");
    }

    @Override
    public String getUrlInfo() {
        return "URL VPN-сервера: " + url;
    }
}
