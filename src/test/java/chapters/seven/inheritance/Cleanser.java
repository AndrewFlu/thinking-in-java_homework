package chapters.seven.inheritance;

public class Cleanser {
    private String label = "Cleanser";

    protected void append(String append) {
        label += append;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    @Override
    public String toString() {
        return label;
    }

    public static void main(String[] args) {
        Cleanser cleanser = new Cleanser();
        cleanser.apply();
        cleanser.dilute();
        cleanser.scrub();

        System.out.println(cleanser);
    }
}
