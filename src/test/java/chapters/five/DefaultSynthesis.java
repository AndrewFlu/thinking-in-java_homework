package chapters.five;

public class DefaultSynthesis {
    @Override
    public String toString() {
        return "DefaultSynthesis{}";
    }
}

class TestDrive {
    public static void main(String[] args) {
        DefaultSynthesis defaultSynthesis = new DefaultSynthesis();
        System.out.println(defaultSynthesis);
    }
}
