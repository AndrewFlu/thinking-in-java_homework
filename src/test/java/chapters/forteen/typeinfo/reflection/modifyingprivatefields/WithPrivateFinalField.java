package chapters.forteen.typeinfo.reflection.modifyingprivatefields;

public class WithPrivateFinalField {
    private int i = 1;
    private final String finalString = "I am totally safe!";
    private String string = "Am I safe?";
    public String toString() {
        return "i = " + i + ", " + finalString + ", " + string;
    }
}
