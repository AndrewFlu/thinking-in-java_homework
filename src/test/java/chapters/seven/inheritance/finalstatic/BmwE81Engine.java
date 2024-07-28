package chapters.seven.inheritance.finalstatic;

public class BmwE81Engine {
    static final Float volume = 2.0f;
    final Integer index;

    public BmwE81Engine(Integer index) {
        this.index = index;
    }

    public static void main(String[] args) {
        BmwE81Engine engine = new BmwE81Engine(120);
        System.out.println("Дефолтный объем: " + engine.volume);
        System.out.println("Индекс модели: " + engine.index);
        BmwE81Engine engine118 = new BmwE81Engine(118);
        System.out.println("Дефолтный объем: " + engine118.volume);
        System.out.println("Индекс модели: " + engine118.index);

        System.out.println("Обновлённый объем: " + volume);
    }
}
