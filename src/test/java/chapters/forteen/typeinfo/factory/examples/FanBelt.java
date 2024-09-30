package chapters.forteen.typeinfo.factory.examples;

public class FanBelt extends Belt {
    public static class Factory implements chapters.forteen.typeinfo.factory.Factory<FanBelt> {
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}
