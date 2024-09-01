package chapters.twelve.exceptions.custom;

public class CustomClassTestDrive {
    public static void main(String[] args) {
        for (int i = 0; i < 7; i++) {
            CustomClass customClass = new CustomClass();
            try {
                System.out.println("id = " + customClass.getId());
            } catch (CustomException e) {
                e.printStackTrace(System.out);
            }
        }
    }
}
