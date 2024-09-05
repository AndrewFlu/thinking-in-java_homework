package chapters.twelve.exceptions.constructors;

public class FailingConstructorTestDrive {
    public static void main(String[] args) {
        try {
            FailingConstructor fc = new FailingConstructor();
            fc.printInfo();
        } catch (ConstructorException e) {
            System.out.println("Перехвачено исключение ConstructorException при попытке конструирования объекта FailingConstructor");
        }
    }
}
