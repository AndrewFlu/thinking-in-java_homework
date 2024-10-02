package chapters.forteen.typeinfo.factory.examples.parts.pojo;

import chapters.forteen.typeinfo.factory.examples.parts.Filter;

public class FuelFilter extends Filter {
    // Создание фабрики класса для каждого конкретного типа
    public static class Factory implements chapters.forteen.typeinfo.factory.examples.parts.Factory<FuelFilter> {

        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }

        @Override
        public FuelFilter newInstance() {
            try {
                return FuelFilter.class.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
