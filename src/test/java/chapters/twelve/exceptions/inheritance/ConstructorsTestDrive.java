package chapters.twelve.exceptions.inheritance;

public class ConstructorsTestDrive {
    public static void main(String[] args) {
        try {
            ChildClass childClass = new ChildClass();
        } catch (BaseClassException e) {
            throw new RuntimeException(e);
        }
    }
}
