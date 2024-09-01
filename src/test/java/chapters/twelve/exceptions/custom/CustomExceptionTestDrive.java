package chapters.twelve.exceptions.custom;

public class CustomExceptionTestDrive {
    public static void main(String[] args) {
        try {
            throw new CustomException("Windows rules");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
