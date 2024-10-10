package chapters.forteen.typeinfo.nullobjects.factories.registered.parts.pojo;

import chapters.forteen.typeinfo.nullobjects.factories.registered.parts.Filter;

public class CabinAirFilter extends Filter {
    public static class Factory implements chapters.forteen.typeinfo.nullobjects.factories.registered.parts.Factory<CabinAirFilter> {

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
