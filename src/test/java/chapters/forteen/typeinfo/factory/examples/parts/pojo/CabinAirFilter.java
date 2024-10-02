package chapters.forteen.typeinfo.factory.examples.parts.pojo;

import chapters.forteen.typeinfo.factory.examples.parts.Filter;

public class CabinAirFilter extends Filter {
    public static class Factory implements chapters.forteen.typeinfo.factory.examples.parts.Factory<CabinAirFilter> {

        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }

        @Override
        public CabinAirFilter newInstance() {
            try {
                return CabinAirFilter.class.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
