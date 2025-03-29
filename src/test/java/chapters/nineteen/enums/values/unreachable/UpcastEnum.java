package chapters.nineteen.enums.values.unreachable;

public class UpcastEnum {
    public static
    void main(String[] args) {
        Search[] vals = Search.values();
        Enum<Search> e = Search.HEATHER;
//        e.values(); // Enum не содержит values()
        for (Enum<?> en : e.getClass().getEnumConstants())
            System.out.println(en);
    }
}
