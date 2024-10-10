package chapters.forteen.typeinfo.nullobjects.factories.registered.parts;

import chapters.forteen.typeinfo.nullobjects.factories.registered.parts.pojo.*;
import chapters.forteen.typeinfo.nullobjects.staff.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Detail {
    private String name;

    public static final Detail NULL = new NullDetail();

    public Detail() {
        this.name = getClass().getSimpleName();;
    }

    public static class NullDetail extends Detail implements Null {
        @Override
        public String toString() {
            return "Null Detail";
        }

        public static class Factory implements chapters.forteen.typeinfo.nullobjects.factories.registered.parts.Factory<NullDetail> {

            @Override
            public NullDetail newInstance() {
                try {
                    return NullDetail.class.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public String toString() {
        return name;
    }

    static List<Factory<? extends Detail>> detailFactories = new ArrayList<Factory<? extends Detail>>();

    static {
        // Для Collections.addAll() выдаётся предупреждение
        // неконтролируемое создание обощённого массива
        detailFactories.add(new FuelFilter.Factory());
        detailFactories.add(new AirFilter.Factory());
        detailFactories.add(new CabinAirFilter.Factory());
        detailFactories.add(new OilFilter.Factory());
        detailFactories.add(new FanBelt.Factory());
        detailFactories.add(new PowerSteeringBelt.Factory());
        detailFactories.add(new GeneratorBelt.Factory());
        detailFactories.add(new NullDetail.Factory());
    }

    private static Random rand = new Random(47);

    public static Detail createRandom() {
        int n = rand.nextInt(detailFactories.size());

        return detailFactories.get(n).newInstance();
    }

    public static List<Detail> createArray(int size) {
        List<Detail> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(createRandom());
        }

        return result;
    }
}
