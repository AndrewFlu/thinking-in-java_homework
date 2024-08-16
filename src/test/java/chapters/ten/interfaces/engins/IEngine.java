package chapters.ten.interfaces.engins;

public interface IEngine {
    void start();

    void stop();

    class Engine {
        static void testEngine(IEngine engine) {
            engine.start();
            engine.stop();
        }
    }
}
