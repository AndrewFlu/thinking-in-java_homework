package chapters.forteen.typeinfo.nullobjects.factories.registered.parts.pojo;

import chapters.forteen.typeinfo.nullobjects.factories.registered.parts.Filter;

public class FuelFilter extends Filter {
    // Создание фабрики класса для каждого конкретного типа
    public static class Factory implements chapters.forteen.typeinfo.nullobjects.factories.registered.parts.Factory<FuelFilter> {

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
