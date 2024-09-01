package chapters.twelve.exceptions.finallyblock;

public class WithFinally {
    static Switch switcher = new Switch();

    public static void main(String[] args) {
        switcher.on();
        // код, способный возбуждать исключения
        try {
            OnOffSwitch.f();
        } catch (OnOffException1 e) {
            throw new RuntimeException(e);
        } catch (OnOffException2 e) {
            throw new RuntimeException(e);
        }
    }
}
