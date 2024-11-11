package chapters.fifteen.generics.constraints.homework;

public class MacBook extends NoteBook implements BeCool, BeNoteBook {

    @Override
    public void checkNoteBookToMacbookTest() {
        System.out.println("Тест на макбук проходит успешно! Это же макбук ;)");
    }

    @Override
    public void workOnBattery() {
        System.out.println("Устройство работает от аккумулятора более 12 часов");
    }
}
