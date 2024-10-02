package chapters.forteen.typeinfo.factory.examples.parts.pojo;

import chapters.forteen.typeinfo.factory.examples.parts.Belt;

public class PowerSteeringBelt extends Belt {
    public static class Factory implements chapters.forteen.typeinfo.factory.examples.parts.Factory<PowerSteeringBelt> {

        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }

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
