package chapters.fifteen.generics.erasedtype.array;

public class ArrayOfGeneric {
    static final int SIZE = 100;
    static GenericClass<Integer>[] genericIntegerArray;


    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // компилируется. Выдаёт ClassCastException
//         genericIntegerArray = (GenericClass<Integer>[]) new Object[SIZE];

        //  тип времени выполнения  - низкоуровневый (стёртый) тип
        genericIntegerArray = (GenericClass<Integer>[]) new GenericClass[SIZE];
        System.out.println(genericIntegerArray.getClass().getSimpleName());

        genericIntegerArray[0] = new GenericClass<Integer>();
//!        genericIntegerArray[1] = new Object(); // ошибка времени компиляции
        // Обнаруживается несоответствие типов
//!        genericIntegerArray[2] = new GenericClass<Double>();
    }
}
