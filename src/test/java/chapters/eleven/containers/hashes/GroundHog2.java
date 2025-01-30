package chapters.eleven.containers.hashes;

public class GroundHog2 extends GroundHog {

    public GroundHog2(int number) {
        super(number);
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public boolean equals(Object arg) {
        return arg instanceof GroundHog2 && (number == ((GroundHog2) arg).number);
    }
}
