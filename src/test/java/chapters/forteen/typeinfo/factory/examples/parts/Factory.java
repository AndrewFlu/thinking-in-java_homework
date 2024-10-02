package chapters.forteen.typeinfo.factory.examples.parts;

public interface Factory<T> {
    T create();
    T newInstance();
}
