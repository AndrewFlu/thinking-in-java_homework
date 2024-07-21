package chapters.five.overloading.chapters.five.sto;

public class StoTestDrive {
    public static void main(String[] args) {
        Car bmw = new Car("BMW");
        TechnicalCenter sto = new TechnicalCenter();
        sto.repair(bmw);

        bmw.setHealth(false);
        sto.repair(bmw);
    }
}
