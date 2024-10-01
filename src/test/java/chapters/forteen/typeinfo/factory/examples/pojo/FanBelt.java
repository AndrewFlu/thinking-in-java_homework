package chapters.forteen.typeinfo.factory.examples.pojo;

import chapters.forteen.typeinfo.factory.examples.Belt;

public class FanBelt extends Belt {
    public static class Factory implements chapters.forteen.typeinfo.factory.Factory<FanBelt> {
        @Override
        public FanBelt create() {
            return new FanBelt();
        }

        @Override
        public FanBelt newInstance() {
            try {
                return FanBelt.class.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
