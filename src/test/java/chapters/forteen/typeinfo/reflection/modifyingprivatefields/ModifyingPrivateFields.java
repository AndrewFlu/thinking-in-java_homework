package chapters.forteen.typeinfo.reflection.modifyingprivatefields;

import java.lang.reflect.Field;

public class ModifyingPrivateFields {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println(pf);

        System.out.println("Change int...");
        Field i = pf.getClass().getDeclaredField("i");
        i.setAccessible(true);
        System.out.println("i.getInt(pf) = " + i.getInt(pf));
        // change i
        i.setInt(pf, 50);
        System.out.println(pf);

        System.out.println("\nTry to change final String...");
        Field finalString = pf.getClass().getDeclaredField("finalString");
        finalString.setAccessible(true);
        System.out.println("finalString.get(pf) = " + finalString.get(pf));
        // try to change finalString
        finalString.set(pf, "No, you are not!");
        System.out.println(pf);

        System.out.println("\nChanging string...");
        Field string = pf.getClass().getDeclaredField("string");
        string.setAccessible(true);
        System.out.println("string.get(pf) = " + string.get(pf));
        // change string
        string.set(pf, "Plain string is not safe!");
        System.out.println(pf);
    }
}
