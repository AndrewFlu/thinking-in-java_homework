package chapters.five.overloading;

import static net.mindview.utils.Print.print;

public class SameTypesDifferentOrder {
    int high;
    String name;

    public SameTypesDifferentOrder(int high, String name) {
        this.high = high;
        this.name = name;
    }

    public SameTypesDifferentOrder(String name, int high) {
        this.name = name;
        this.high = high;
    }

    static void printName(String prefix, SameTypesDifferentOrder plant) {
        print(prefix + " " + plant.name);
    }

    static void printName(SameTypesDifferentOrder plant, String prefix) {
        print("Перегрузка с другим порядком аргументов: " + prefix + " " + plant.name);
    }

    public static void main(String[] args) {
        SameTypesDifferentOrder flower = new SameTypesDifferentOrder(0, "monsterra");
        SameTypesDifferentOrder tree = new SameTypesDifferentOrder("oukume", 15);

        print(flower.toString());
        print(tree.toString());
        print("");
        printName("Комнатное растение —", flower);
        printName("Гитары изготавливают из дерева —", tree);
        print("");
        printName(flower,"Комнатное растение —");
        printName(tree, "Гитары изготавливают из дерева —");
    }
}