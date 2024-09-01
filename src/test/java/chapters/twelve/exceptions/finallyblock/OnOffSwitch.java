package chapters.twelve.exceptions.finallyblock;

public class OnOffSwitch {
    private static final Switch sw = new Switch();

    public static void f() throws OnOffException1, OnOffException2{
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            sw.on();
            // Код, который может возбуждать исключения
            f();
            sw.off();
        } catch (OnOffException1 ex1) {
            System.out.println("OnOffException1");
            sw.off();
        } catch (OnOffException2 ex2) {
            System.out.println("OnOffException2");
            sw.off();
        }
    }

}
