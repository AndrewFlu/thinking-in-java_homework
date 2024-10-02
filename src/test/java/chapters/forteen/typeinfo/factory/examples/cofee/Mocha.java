package chapters.forteen.typeinfo.factory.examples.cofee;

public class Mocha extends Cofee {
    static class Factory implements IFactory<Mocha> {
        @Override
        public Mocha create() {
            return new Mocha();
        }
    }
}
