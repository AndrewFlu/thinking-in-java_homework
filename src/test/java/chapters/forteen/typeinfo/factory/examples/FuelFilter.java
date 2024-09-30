package chapters.forteen.typeinfo.factory.examples;

public class FuelFilter extends Filter {
    // Создание фабрики класса для каждого конкретного типа
    public static class Factory implements chapters.forteen.typeinfo.factory.Factory<FuelFilter> {

        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}
