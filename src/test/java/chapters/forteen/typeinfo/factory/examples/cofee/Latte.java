package chapters.forteen.typeinfo.factory.examples.cofee;

public class Latte extends Cofee {
    static class Factory implements IFactory<Latte> {
        @Override
        public Latte create() {
            return new Latte();
        }
    }

}
