package chapters.nine.interfaceexamples.inheritance;

public interface ICar extends IManufacturer, IEngine, IDrive {

    String getColor();
}
