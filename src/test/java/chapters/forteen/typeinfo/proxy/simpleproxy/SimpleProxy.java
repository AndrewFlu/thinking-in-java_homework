package chapters.forteen.typeinfo.proxy.simpleproxy;

import static net.midview.Print.print;

public class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        // дополнительное поведение, наделяемое proxy-объекту
        print("SimpleProxy do something...");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        print("SimpleProxy something else... " + arg);
        proxied.somethingElse(arg);
    }
}
