package chapters.forteen.typeinfo.proxy.simpleproxy;

import static net.midview.Print.print;

public class SimpleProxyDemo {
    public static void consumer(Interface iFace) {
        iFace.doSomething();
        iFace.somethingElse("boo-boo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        print("");
        consumer(new SimpleProxy(new RealObject()));
    }
}
