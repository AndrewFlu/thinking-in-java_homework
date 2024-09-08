package chapters.twelve.exceptions;

public class IndexExceptionTestDrive {
    public static void main(String[] args) {
        try {
            Integer[] ints = {1, 2, 3, 4, 5};
            Integer outOfBound = ints[5];
            System.out.println(outOfBound);
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new RuntimeException(ex);
        }
    }
}
