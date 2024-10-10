package chapters.forteen.typeinfo.nullobjects.factories.registered.parts.pojo;

import chapters.forteen.typeinfo.nullobjects.factories.registered.parts.Belt;

public class PowerSteeringBelt extends Belt {
    public static class Factory implements chapters.forteen.typeinfo.nullobjects.factories.registered.parts.Factory<PowerSteeringBelt> {

        @Override
        public PowerSteeringBelt newInstance() {
            try {
                return PowerSteeringBelt.class.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
