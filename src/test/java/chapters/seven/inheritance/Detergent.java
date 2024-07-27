package chapters.seven.inheritance;

public class Detergent {
    private final Cleanser cleanser = new Cleanser();

    public void scrub() {
        cleanser.append(" Вызов scrub() делегирован в Cleanser");
        cleanser.scrub();
    }

    public void foam() {
        cleanser.append(" foam()");
    }

    private void dilute() {
        cleanser.dilute();
    }

    private void apply() {
        cleanser.apply();
    }

    public String toString() {
        return cleanser.toString();
    }

    public static void main(String[] args) {
        Detergent detergent = new Detergent();
        detergent.scrub();
        detergent.dilute();
        detergent.apply();
        detergent.foam();

        System.out.println(detergent);
        System.out.println("");
        System.out.println("А теперь вызовем main() в базовом классе Cleanser");
        Cleanser.main(args);
    }
}
