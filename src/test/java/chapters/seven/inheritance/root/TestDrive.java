package chapters.seven.inheritance.root;

public class TestDrive {
    public static void main(String[] args) {
            Stem s = new Stem(2);
        try {
            System.out.println(s.component1.label);
            System.out.println(s.component2.label);
            System.out.println(s.component3.label);
        } finally {
            s.dispose();
        }
    }
}
