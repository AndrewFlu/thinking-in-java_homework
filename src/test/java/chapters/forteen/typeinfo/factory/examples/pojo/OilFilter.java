package chapters.forteen.typeinfo.factory.examples.pojo;

import chapters.forteen.typeinfo.factory.examples.Filter;

public class OilFilter extends Filter {
    public static class Factory implements chapters.forteen.typeinfo.factory.Factory<OilFilter> {

        @Override
        public OilFilter create() {
            return new OilFilter();
        }

        @Override
        public OilFilter newInstance() {
            try {
                return OilFilter.class.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
