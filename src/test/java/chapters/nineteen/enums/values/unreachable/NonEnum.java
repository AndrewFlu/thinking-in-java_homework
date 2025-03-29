package chapters.nineteen.enums.values.unreachable;

public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> integerClass = Integer.class;
        try {
            for (Object o : integerClass.getEnumConstants())
                System.out.println(o);
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
