package chapters.forteen.typeinfo.reflection.instrument;

public enum Note {
    C("До"),
    D("Ре"),
    E("Ми"),
    F("Фа"),
    G("Соль"),
    A("Ля"),
    B("Си"),
    ;
    private final String name;

    Note(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
