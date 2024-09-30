package chapters.forteen.typeinfo.factory.examples;

public class AirFilter extends Filter {
    public static class Factory implements chapters.forteen.typeinfo.factory.Factory<AirFilter> {

        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}
