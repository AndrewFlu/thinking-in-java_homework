package chapters.forteen.typeinfo.proxy.vpn;

public abstract class AbstractVpn implements Vpn {
    protected String vpnName;
    protected String url;

    public AbstractVpn(String url) {
        this.url = url;
    }
}
