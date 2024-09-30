package chapters.forteen.typeinfo.factory.examples;

public class PowerSteeringBelt extends Belt {
    public static class Factory implements chapters.forteen.typeinfo.factory.Factory<PowerSteeringBelt> {

        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}
