package chapters.forteen.typeinfo.factory.examples;

public class OilFilter extends Filter {
    public static class Factory implements chapters.forteen.typeinfo.factory.Factory<OilFilter> {

        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}
