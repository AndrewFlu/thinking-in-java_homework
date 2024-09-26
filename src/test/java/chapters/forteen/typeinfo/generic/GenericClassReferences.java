package chapters.forteen.typeinfo.generic;

public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> integerClass = int.class;
        integerClass = Integer.class; // то же самое
        intClass = double.class;
//        integerClass = double.class; // недопустимо
    }
}
