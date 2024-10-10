package chapters.forteen.typeinfo.nullobjects.factories.registered.parts.pojo;

import chapters.forteen.typeinfo.nullobjects.factories.registered.parts.Filter;

public class OilFilter extends Filter {
    public static class Factory implements chapters.forteen.typeinfo.nullobjects.factories.registered.parts.Factory<OilFilter> {

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
