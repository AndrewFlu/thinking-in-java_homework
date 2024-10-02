package chapters.forteen.typeinfo.factory.examples.parts.pojo;

import chapters.forteen.typeinfo.factory.examples.parts.Belt;

public class GeneratorBelt extends Belt {
    public static class Factory implements chapters.forteen.typeinfo.factory.examples.parts.Factory<GeneratorBelt> {

        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }

        @Override
        public GeneratorBelt newInstance() {
            try {
                return GeneratorBelt.class.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
