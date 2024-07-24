package chapters.six.packageprivate;

public class DieselEngine extends Engine {
    public DieselEngine(String model) {
        super(EngineType.DIESEL);
        setModel(model);
    }
}