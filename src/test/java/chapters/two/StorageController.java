package chapters.two;

public class StorageController {
    /**
     * Рассчитывает объём памяти, необходимй для хранения строки, переданной в аргументе, в байтах
     * @param s строка, для которой будет выполнен расчёт
     * @return размер памяти в байтах
     */
    public int storage(String s) {
        return s.length() * 2;
    }
}
