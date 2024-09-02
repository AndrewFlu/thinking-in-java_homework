package chapters.twelve.exceptions.lostexception;

public class LostMessageTestDrive {
    public static void main(String[] args) {
        LostMessage lostMessage = new LostMessage();
        try {
            try {
                lostMessage.mainAction();
            } finally {
                try {
                    lostMessage.dispose();
                } finally {
                    throw new ThirdPriorityException();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
