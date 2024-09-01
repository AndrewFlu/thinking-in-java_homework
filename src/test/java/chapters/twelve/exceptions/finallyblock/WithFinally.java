package chapters.twelve.exceptions.finallyblock;

public class WithFinally {
    static Switch switcher = new Switch();

    public static void main(String[] args) {
        try {
            switcher.on();
            // код, способный возбуждать исключения
            OnOffSwitch.f();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
        } finally {
            switcher.off();
        }
    }
}
