package chapters.fifteen.generics.erasedtype.compensation;

public class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean isInstanceOfTypeClassTypeCapture(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> buildingType = new ClassTypeCapture<>(Building.class);
        System.out.println(buildingType.isInstanceOfTypeClassTypeCapture(new Building()));
        System.out.println(buildingType.isInstanceOfTypeClassTypeCapture(new House()));

        ClassTypeCapture<House> houseType = new ClassTypeCapture<>(House.class);
        System.out.println(houseType.isInstanceOfTypeClassTypeCapture(new Building()));
        System.out.println(houseType.isInstanceOfTypeClassTypeCapture(new House()));
    }
}
