package chapters.twelve.exceptions.finallyblock.multiexception;

public class HomeTaskTestDrive {
    public static void main(String[] args) {
        HomeTask ht = new HomeTask();
        try {
            ht.testIgnition();
        } catch (IgnitionException e) {
            System.out.println("Перехвачено исключение при вызове метода testIgnition()");
            e.printStackTrace(System.out);
        }

        try {
            ht.testEngine(); // throws RuntimeException
        } finally {
            System.out.println("Двигатель неисправен. Направляйтесь на СТО");
        }
    }
}
