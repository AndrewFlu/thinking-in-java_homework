package chapters.twenty_one.concurrency.variants_of_implementation.inner_classes;

// Использование анонимного внутреннего класса
class InnerThread2 {
    private int countDown = 5;
    private Thread t;

    public InnerThread2(String name) {
        t = new Thread(name) {
          public void run() {
              try {
                  while (true) {
                      System.out.println(this);
                      if (--countDown == 0)
                          return;
                      sleep(10);
                  }
              } catch (InterruptedException e) {
                  System.err.println("sleep() interrupted");
              }
          }

          public String toString() {
              return getName() + ": " + countDown;
          }
        };
        t.start();
    }
}
