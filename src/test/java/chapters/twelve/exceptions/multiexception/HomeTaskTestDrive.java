package chapters.twelve.exceptions.multiexception;

public class HomeTaskTestDrive {
    public static void main(String[] args) {
        HomeTask ht = new HomeTask();
        try {
            ht.testIgnition();
        } catch (IgnitionException e) {
            System.out.println("Перехвачено исключение при вызове метода testIgnition()");
            e.printStackTrace(System.out);
        }

        ht.testEngine();
    }
}
