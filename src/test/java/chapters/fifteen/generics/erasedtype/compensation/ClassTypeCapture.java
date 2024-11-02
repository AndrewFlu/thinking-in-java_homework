package chapters.fifteen.generics.erasedtype.compensation;

import java.util.HashMap;
import java.util.Map;

public class ClassTypeCapture<T> {
    Class<T> kind;
    Map<String, Class<?>> kindMap = new HashMap<>();


    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
        kindMap.put(kind.getSimpleName(), kind);
    }

    public boolean isInstanceOfTypeClassTypeCapture(Object arg) {
        return kind.isInstance(arg);
    }

    public void addType(String typeName, Class<?> kind) {
        kindMap.put(typeName, kind);
    }

    @SuppressWarnings("unchecked")
    public <Type> Type createNew(String typename) {
        try {
            return (Type) Class.forName(typename).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException("Не удалось создать экземпляр класса: " + typename);
        }
    }

    public static void main(String[] args) {
        ClassTypeCapture<Building> buildingType = new ClassTypeCapture<>(Building.class);
        System.out.println(buildingType.isInstanceOfTypeClassTypeCapture(new Building()));
        System.out.println(buildingType.isInstanceOfTypeClassTypeCapture(new House()));

        ClassTypeCapture<House> houseType = new ClassTypeCapture<>(House.class);
        System.out.println(houseType.isInstanceOfTypeClassTypeCapture(new Building()));
        System.out.println(houseType.isInstanceOfTypeClassTypeCapture(new House()));

        System.out.println(houseType.kindMap);
        houseType.addType("Building", Building.class);
        System.out.println(houseType.kindMap);

        Object string = houseType.createNew("java.lang.String");
        System.out.println(string.getClass());
    }
}
