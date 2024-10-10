package chapters.forteen.typeinfo.nullobjects.factories.registered.parts.pojo;

import chapters.forteen.typeinfo.nullobjects.factories.registered.parts.Belt;

public class GeneratorBelt extends Belt {
    public static class Factory implements chapters.forteen.typeinfo.nullobjects.factories.registered.parts.Factory<GeneratorBelt> {

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
