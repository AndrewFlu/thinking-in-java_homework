package chapters.ten.interfaces;

public interface ClassInInterface {
    void howdy();

    class Test implements ClassInInterface {

        @Override
        public void howdy() {
            System.out.println("Привет из вложенного в интерфейс класса!");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
