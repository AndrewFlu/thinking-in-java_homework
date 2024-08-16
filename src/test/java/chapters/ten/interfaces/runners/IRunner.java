package chapters.ten.interfaces.runners;

public interface IRunner {
    void run();

    class Marathonist implements IRunner {

        @Override
        public void run() {
            System.out.println("Бежать дистанцию в 24 км.");
        }
    }
}
