package chapters.forteen.typeinfo.cast;

class Building{
    @Override
    public String toString() {
        return "Building{}";
    }
}
class House extends Building{
    @Override
    public String toString() {
        return "House{}";
    }
}

public class ClassCast {
    public static void main(String[] args) {
        Building building = new House();
        Class<House> houseType = House.class;
        // cast()
        House house = houseType.cast(building);
        System.out.println(house);
        // или так (Class)
        house = (House)building;
        System.out.println(house);
    }
}
