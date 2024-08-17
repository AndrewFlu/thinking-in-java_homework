package chapters.ten.closures;

public class Callee2 extends MyIncrement {
    private int i = 0;

    private void innerClosedIncrement() {
        super.increment();
        i++;
        System.out.println("Callee 2 i = " + i);
    }

    Incrementable getCallBackReference() {
        return new Closure();
    }

    private class Closure implements Incrementable {

        @Override
        public void increment() {
            // Указывается метод внешнего класса,
            // иначе возникнет рекурсия
            Callee2.this.innerClosedIncrement();
        }
    }

}
