package chapters.seven.inheritance;

public class Aos extends Detergent{
    private String label = "AOS";

    public Aos() {
        System.out.println("Конструктор Aos");
    }

    @Override
    public void scrub() {
        System.out.println("Переопределённый метод scrub() в Aos");
        super.scrub();
    }

    public void sterilize() {
        System.out.println("Aos also sterilized dishes");
    }
    @Override
    public String toString() {
        return label;
    }
    public static void main(String[] args) {
        Aos aos = new Aos();
        System.out.println(aos);

        aos.sterilize();
    }
}
