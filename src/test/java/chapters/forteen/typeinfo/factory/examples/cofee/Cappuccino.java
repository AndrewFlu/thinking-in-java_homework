package chapters.forteen.typeinfo.factory.examples.cofee;

public class Cappuccino extends Cofee {
    static class Factory implements IFactory<Cappuccino> {

        @Override
        public Cappuccino create() {
            return new Cappuccino();
        }
    }
}
