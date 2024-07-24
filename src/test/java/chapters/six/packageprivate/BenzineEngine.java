package chapters.six.packageprivate;

public class BenzineEngine extends Engine {
    public BenzineEngine(String model) {
        super(EngineType.BENZINE);
        setModel(model);
    }
}
