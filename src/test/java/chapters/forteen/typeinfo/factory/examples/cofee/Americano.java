package chapters.forteen.typeinfo.factory.examples.cofee;

public class Americano extends Cofee {
    static class Factory implements IFactory<Americano> {

        @Override
        public Americano create() {
            return new Americano();
        }
    }
}
