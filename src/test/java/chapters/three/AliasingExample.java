package chapters.three;

public class AliasingExample {

    public static void main(String[] args) {
        Aliasing room = new Aliasing();
        Aliasing bathroom = new Aliasing();
        room.temperature = 25.1F;
        bathroom.temperature = 27.5F;

        printTemperatureData(room, bathroom);
        bathroom = room;
        System.out.println("Объединили ванную с залом");
        printTemperatureData(room, bathroom);
    }

    private static void printTemperatureData(Aliasing room, Aliasing bathroom) {
        System.out.println("Room temperature = " + room.temperature);
        System.out.println("Bathroom temperature = " + bathroom.temperature);
    }

}

class Aliasing {
    float temperature;
 }