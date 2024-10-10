package chapters.forteen.typeinfo.proxy.vpn;

public class VpnTestDrive {
    public static void main(String[] args) {
        Vpn openVpn = new OpenVpn("https://openvpn.ru");

        System.out.println("Воспользуемся записью логов VPN");
        Vpn openVpnUnsecure = new VpnRequestLogger(openVpn);
        openVpnUnsecure.connect();
    }
}
