package chapters.twelve.exceptions.constructors;

public class FailingConstructor {
    public FailingConstructor() throws ConstructorException {
        System.out.println("Вызван конструктор FailingConstructor()");
        throw new ConstructorException("Ошибка при конструировании объекта FailingConstructor");
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "FailingConstructor{}";
    }
}
