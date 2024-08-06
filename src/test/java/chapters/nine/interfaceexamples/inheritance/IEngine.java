package chapters.nine.interfaceexamples.inheritance;

public interface IEngine {

    double getVolume();

    FuelType getType();

    enum FuelType {
        BENZINE ("Бензин"),
        DIESEL ("Дизель")
        ;
        final String name;

        FuelType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
