package chapters.forteen.typeinfo.nullobjects.factories.registered.parts.pojo;

import chapters.forteen.typeinfo.nullobjects.factories.registered.parts.Filter;

public class AirFilter extends Filter {
    public static class Factory implements chapters.forteen.typeinfo.nullobjects.factories.registered.parts.Factory<AirFilter> {

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
