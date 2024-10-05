package chapters.forteen.typeinfo.proxy.simpleproxy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static net.midview.Print.print;

public class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        // дополнительное поведение, наделяемое proxy-объекту
        print("Метод Interface.doSomething() вызван " + LocalDateTime.now());
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        print("Метод Interface.somethingElse(String arg) вызван " + LocalDateTime.now());
        proxied.somethingElse(arg);
    }
}
