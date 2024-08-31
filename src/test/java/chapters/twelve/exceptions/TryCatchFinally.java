package chapters.twelve.exceptions;

public class TryCatchFinally {
    public static void main(String[] args) {
        try {
            throw new Exception("Выброшено исключение");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Блок finally выполняется всегда");
        }
    }
}
