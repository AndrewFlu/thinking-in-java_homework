package chapters.six.packageprivate;

import static net.midview.Print.print;

public class Engine {
    private int baseId;
    private String model;
    protected EngineType engineType;

    public Engine(EngineType engineType) {
        this.engineType = engineType;
    }

    public void start() {
        print("Двигатель запущен!");
    }

    public void stop() {
        print("Двигатель заглушён");
    }

    int getBaseId() {
        return baseId;
    }

    protected void setModel(String model) {
        this.model = model;
    }

    public final  String getModel() {
        return model;
    }
}
