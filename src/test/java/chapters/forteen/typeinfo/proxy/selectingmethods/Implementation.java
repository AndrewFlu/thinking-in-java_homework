package chapters.forteen.typeinfo.proxy.selectingmethods;

import static net.midview.Print.print;

public class Implementation implements SomeMethods {
    @Override
    public void boring1() {
        print("Boring 1");
    }

    @Override
    public void boring2() {
        print("Boring 2");
    }

    @Override
    public void interesting(String arg) {
        print("Interesting " + arg);
    }

    @Override
    public void boring3() {
        print("Boring 3");
    }
}
