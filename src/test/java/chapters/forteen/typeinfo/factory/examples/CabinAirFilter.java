package chapters.forteen.typeinfo.factory.examples;

public class CabinAirFilter extends Filter {
    public static class Factory implements chapters.forteen.typeinfo.factory.Factory<CabinAirFilter> {

        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}
