package chapters.twelve.exceptions.lostexception;

public class LostMessageTestDrive {
    public static void main(String[] args) {
        try {
            LostMessage lostMessage = new LostMessage();
            try {
                lostMessage.mainAction();
            } catch (VeryImportantException e) {
                throw new RuntimeException(e);
            } finally {
                lostMessage.dispose();
            }
        } catch (Exception ex) {
            System.out.println("Блок catch (Exception)");
            System.out.println(ex);
        }
    }
}
