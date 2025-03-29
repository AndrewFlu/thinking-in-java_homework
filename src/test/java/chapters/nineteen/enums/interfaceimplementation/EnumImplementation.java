package chapters.nineteen.enums.interfaceimplementation;

import net.mindview.utils.Generator;

public class EnumImplementation {
    public static <T> void printNext(Generator<T> rg) {
        System.out.print(rg.next() + ", ");
    }

    public static void main(String[] args) {
        // Выбрать любой экземпляр
        CartoonCharacter character = CartoonCharacter.SPANKY;
        for (int i = 0; i < 10; i++) {
            printNext(character);
        }
    }
}
