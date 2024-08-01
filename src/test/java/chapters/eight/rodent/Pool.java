package chapters.eight.rodent;

public class Pool {
    private static long counter;
    private final long id = counter++;

    private long referenceCount = 0;

    public Pool() {
        System.out.println("Pool created: " + this);
    }

    public void addReferenceCount() {
        referenceCount++;
        System.out.println("вызван addRefereceCount(): " + referenceCount);
    }

    public void dispose() {
        if (--referenceCount == 0) {
            System.out.println("Pool.dispose()");
        } else {
            System.out.println("Ошибка: метод Pool.dispose() не может быть вызван. Есть активные ссылки на объект");
        }
    }

    public String toString() {
        return "Pool_" + id;
    }
}
