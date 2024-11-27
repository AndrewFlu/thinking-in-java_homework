package chapters.fifteen.generics.dinamictypes;

import chapters.fifteen.generics.cofee.Americano;
import chapters.fifteen.generics.cofee.Cappuccino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoffeeCheckedList {
    public static void main(String[] args) {
        List<Americano> testList = new ArrayList<>();
        updateProbablyAmericanoList(testList);

        List surtainAmericanoList = Collections.checkedList(new ArrayList<>(), Americano.class);
        surtainAmericanoList.add(new Americano());
        try {
            surtainAmericanoList.add(new Cappuccino());
        } catch (ClassCastException e) {
            System.out.println("Попытка добавить в список не подходящий тип. \n" + e);
        }

        try {
            updateProbablyAmericanoList(surtainAmericanoList);
        } catch (ClassCastException ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("unchecked")
    private static void updateProbablyAmericanoList(List list) {
        list.add(new Cappuccino());
    }
}
