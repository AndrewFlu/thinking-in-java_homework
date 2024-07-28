package chapters.seven.inheritance;

public class Constants {
    public final int index;
    public final Info label;

    public Constants() {
        index = 1;
        label = new Info("Label");
    }

    public Constants(int index, Info label) {
        this.index = index;
        this.label = label;
    }

    public static void main(String[] args) {
        Constants
                c = new Constants(),
                d = new Constants(5, new Info("Second label"));

        System.out.println(c.index);
        System.out.println(c.label);

        System.out.println(d.index);
        System.out.println(d.label);
    }
}

class Info {
    private String label;

    public Info(String label) {
        this.label = label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
