package chapters.forteen.typeinfo.proxy.simpleproxy;

import static net.mindview.utils.Print.print;

public class RealObject implements Interface{
    @Override
    public void doSomething() {
        print("do something");
    }

    @Override
    public void somethingElse(String arg) {
        print("something else " + arg);
    }
}
