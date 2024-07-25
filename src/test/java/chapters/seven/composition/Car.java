package chapters.seven.composition;

public class Car {
    Engine engine;

    private void printEngineInfo() {
        if (engine == null) {
            engine = new Engine();
            System.out.println("Выполнена отложенная инициализация поля Engine");
        }
        System.out.println("В данном автомобиле установлен двигатель " + engine);
    }
    public static void main(String[] args) {
        Car car = new Car();
        car.printEngineInfo();
    }
}
