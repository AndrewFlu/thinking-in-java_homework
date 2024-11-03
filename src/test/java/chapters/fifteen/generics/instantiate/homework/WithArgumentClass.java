package chapters.fifteen.generics.instantiate.homework;

public class WithArgumentClass {
    private final int id;
    private final String title;

    public WithArgumentClass(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "WithArgumentClass{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
