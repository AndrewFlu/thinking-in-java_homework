package chapters.forteen.typeinfo.factory.examples.pojo;

import chapters.forteen.typeinfo.factory.examples.Filter;

public class AirFilter extends Filter {
    public static class Factory implements chapters.forteen.typeinfo.factory.Factory<AirFilter> {

        @Override
        public AirFilter create() {
            return new AirFilter();
        }

        @Override
        public AirFilter newInstance() {
            try {
                return AirFilter.class.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
