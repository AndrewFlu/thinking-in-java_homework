package chapters.five.overloading.chapters.five;

import java.util.Arrays;

import static net.midview.Print.print;

public class AutoBrand {
    String name;

    public AutoBrand(String name) {
        System.out.println(String.format("Создание экземпляра %s с параметром name = %s", getClass().getSimpleName(), name));
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        AutoBrand[] carBrands = new AutoBrand[]{
                new AutoBrand("Audi"),
                new AutoBrand("BMW"),
                new AutoBrand("Mercedes")
        };

        print(Arrays.toString(carBrands));
    }
}