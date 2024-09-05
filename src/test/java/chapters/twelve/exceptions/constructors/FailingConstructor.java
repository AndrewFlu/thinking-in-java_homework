package chapters.twelve.exceptions.constructors;

public class FailingConstructor {
    private final HasDispose hasDispose1;
    private final HasDispose hasDispose2;

    public FailingConstructor(Object o) throws ConstructorException {
        System.out.println("Вызван конструктор FailingConstructor()");

        hasDispose1 = new HasDispose();

        if (o == null) {
            try {
                throw new ConstructorException("Ошибка при конструировании объекта FailingConstructor");
            } catch (ConstructorException ex) {
                hasDispose1.dispose();
                throw ex;
            }
        }

        hasDispose2 = new HasDispose();
    }

    public void printInfo() {
        System.out.println(this);
    }

    public void dispose() {
        System.out.println("Завершающие действия для " + this);
        hasDispose2.dispose();
        hasDispose1.dispose();
    }

    @Override
    public String toString() {
        return "FailingConstructor";
    }
}
