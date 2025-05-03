package chapters.twenty_one.concurrency.variants_of_implementation.inner_classes;

// Использование именованного внутреннего класса
class InnerThread1 {
    private int countDown = 5;
    private Inner inner;

    public InnerThread1(String name) {
        inner = new Inner(name);
    }

    private class Inner extends Thread {
        public Inner(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0)
                        return;
                    sleep(10);
                }
            } catch (InterruptedException e) {
                System.err.println("Interrupted");
            }
        }

        public String toString() {
            return getName() + ": " + countDown;
        }
    }
}
