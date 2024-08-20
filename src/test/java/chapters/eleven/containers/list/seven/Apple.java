package chapters.eleven.containers.list.seven;

public class Apple {
    private String sort;

    public Apple(String sort) {
        this.sort = sort;
    }

    public String getSort() {
        return sort;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "sort='" + sort + '\'' +
                '}';
    }
}
