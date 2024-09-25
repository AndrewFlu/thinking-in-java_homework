package chapters.forteen.typeinfo.charinfo;

public class CharTypeInfo {
    public static void main(String[] args) {
        System.out.printf("Массив char[] является %s%n", getTypeInfo(char[].class));
    }

    private static String getTypeInfo(Class<char[]> aClass) {
        return aClass.isPrimitive() ? " примитивом" : " объектом";}
}
