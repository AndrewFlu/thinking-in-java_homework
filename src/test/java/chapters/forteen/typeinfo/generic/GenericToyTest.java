package chapters.forteen.typeinfo.generic;

import chapters.forteen.typeinfo.toys.FancyToy;
import chapters.forteen.typeinfo.toys.Toy;

public class GenericToyTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<FancyToy> fancyToyClass = FancyToy.class;

        // создаётся точный тип
        FancyToy fancyToy = fancyToyClass.newInstance();

        Class<? super FancyToy> up = fancyToyClass.getSuperclass();
        // не компилируется
//        Class<Toy> up2 = fancyToyClass.getSuperclass();

        // создаёт только Object
        Object object = up.newInstance();
    }

}
