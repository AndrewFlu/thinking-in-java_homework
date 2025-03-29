package chapters.nineteen.enums.interfaceimplementation.vs.staticmethods;

import chapters.nineteen.enums.interfaceimplementation.CartoonCharacter;

public class StaticMethodDemo {
    public static <T> void printNext(CartoonChar character) {
        System.out.print(character.next() + ", ");
    }

    public static void main(String[] args) {
        // Выбрать любой экземпляр
        CartoonChar character = CartoonChar.SPANKY;
        for (int i = 0; i < 10; i++) {
            printNext(character);
        }
    }
}
