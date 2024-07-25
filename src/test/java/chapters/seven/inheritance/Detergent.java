package chapters.seven.inheritance;

public class Detergent extends Cleanser {
    public void scrub() {
        append(" Переопределённый метод scrub() в Detergent");
        super.scrub();
    }

    public void foam() {
        append(" foam()");
    }

    public static void main(String[] args) {
        Detergent detergent = new Detergent();
        detergent.dilute();
        detergent.apply();
        detergent.scrub();
        detergent.foam();

        System.out.println(detergent);
        System.out.println("А теперь вызовем main() в базовом классе Cleanser");
        Cleanser.main(args);
    }
}
