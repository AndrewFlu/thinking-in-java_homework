package chapters.forteen.typeinfo.factory.examples;

import chapters.forteen.typeinfo.factory.Factory;
import chapters.forteen.typeinfo.factory.examples.pojo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Part {
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();

    static {
        // Для Collections.addAll() выдаётся предупреждение
        // неконтролируемое создание обощённого массива
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }

    private static Random rand = new Random(47);

    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());

        return partFactories.get(n).newInstance();
    }

    public static List<Part> createArray(int size) {
        List<Part> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(createRandom());
        }

        return result;
    }
}
