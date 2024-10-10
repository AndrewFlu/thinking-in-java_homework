package chapters.forteen.typeinfo.nullobjects.factories.registered.parts.pojo;

import chapters.forteen.typeinfo.nullobjects.factories.registered.parts.Belt;

public class FanBelt extends Belt {
    public static class Factory implements chapters.forteen.typeinfo.nullobjects.factories.registered.parts.Factory<FanBelt> {
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
