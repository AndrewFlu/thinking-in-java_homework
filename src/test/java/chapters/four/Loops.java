package chapters.four;

public class Loops {
    public static void main(String[] args) {
        for (int i = 1; i <= 104; i++) {
            System.out.println(i);
            if (i == 99) {
                break;
            }
        }
        System.out.println("break");
    }
}
