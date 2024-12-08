package chapters.fifteen.generics.latent.useadapters;

import chapters.fifteen.generics.cofee.Americano;
import chapters.fifteen.generics.cofee.Coffee;
import chapters.fifteen.generics.cofee.Latte;
import chapters.forteen.typeinfo.interfaceviolation.A;

import java.util.ArrayList;
import java.util.List;

public class Fill2TestDrive {
    public static void main(String[] args) {
        // Адаптиция Collection
        List<Coffee> carrier = new ArrayList<>();

        Fill2.fill(new AddableCollectionAdapter<Coffee>(carrier), Coffee.class, 5);

        // Вспомогательный метод фиксирует тип
        Fill2.fill(Adapter.collectionAdapter(carrier), Coffee.class, 4);

        for (Coffee c : carrier) {
            System.out.println(c);
        }
        System.out.println("------------");

        // Использование адаптированного класса
        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<>();
        Fill2.fill(coffeeQueue, Americano.class, 5);
        Fill2.fill(coffeeQueue, Latte.class, 5);
        for (Coffee c : coffeeQueue) {
            System.out.println(c);
        }
    }
}
