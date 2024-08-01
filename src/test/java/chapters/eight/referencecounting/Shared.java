package chapters.eight.referencecounting;

public class Shared {
    private static long counter = 0;

    private int referenceCount = 0;
    private final long id = counter++;

    public Shared() {
        System.out.println("Создаём " + this);
    }

    public void addReference() {
        referenceCount++;
    }

    protected void dispose() {
        if (--referenceCount == 0) {
            System.out.println("Завершаем " + this);
        }
    }

    public String toString() {
        return "Shared " + id;
    }

    @Override
    public void finalize(){
        if (referenceCount != 0) {
            System.out.println("ERROR: объект Shared имеет активные ссылки");
        } else {
            System.out.println("Финализация успешно выполнена");
        }
    }
}