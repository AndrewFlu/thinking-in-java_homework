package chapters.twelve.exceptions.inheritance;

public class ChildClass extends BaseClass {
    public ChildClass() throws BaseClassException {
    }
    // не компилируется: конструктор дочернего класса не может перехватывать исключения,
    // возбуждаемые конструктором базового класса
//    public ChildClass() {
////        try {
//////            super();
////        } catch (BaseClassException e) {
////            throw new RuntimeException(e);
////        }
//    }
}
