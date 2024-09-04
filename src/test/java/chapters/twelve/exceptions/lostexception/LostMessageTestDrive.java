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
                    try {
                        throw new ThirdPriorityException();
                    } catch (ThirdPriorityException ex) {
                        System.out.println(ex);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
