package chapters.forteen.typeinfo.factory.examples;

public class GeneratorBelt extends Belt {
    public static class Factory implements chapters.forteen.typeinfo.factory.Factory<GeneratorBelt> {

        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}
