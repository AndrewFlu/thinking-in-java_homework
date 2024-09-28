package chapters.forteen.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();

    // Типы, которые должны создаваться случайным образом
    private static String[] typeNames = {
            "chapters/forteen/typeinfo/pets/Mutt.java",
            "chapters/forteen/typeinfo/pets/Pug.java",
            "chapters/forteen/typeinfo/pets/EgyptianMau.java",
            "chapters/forteen/typeinfo/pets/Manx.java",
            "chapters/forteen/typeinfo/pets/Cymric.java",
            "chapters/forteen/typeinfo/pets/Rat.java",
            "chapters/forteen/typeinfo/pets/Mouse.java",
            "chapters/forteen/typeinfo/pets/Hamster.java",
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    public List<Class<? extends Pet>> types() {
        return types;
    }
}
