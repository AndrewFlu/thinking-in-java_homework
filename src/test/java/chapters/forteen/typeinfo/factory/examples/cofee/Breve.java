package chapters.forteen.typeinfo.factory.examples.cofee;

public class Breve extends Cofee {
    static class Factory implements IFactory<Breve> {

        @Override
        public Breve create() {
            return new Breve();
        }
    }
}
