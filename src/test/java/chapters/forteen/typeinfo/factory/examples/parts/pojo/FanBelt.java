package chapters.forteen.typeinfo.factory.examples.parts.pojo;

import chapters.forteen.typeinfo.factory.examples.parts.Belt;

public class FanBelt extends Belt {
    public static class Factory implements chapters.forteen.typeinfo.factory.examples.parts.Factory<FanBelt> {
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
