package chapters.fifteen.generics.constraints.homework;

public class NoteBookUtility {

    public static <T extends BeCool> void passMacBookTest(T noteBook) {
        System.out.println("Выполняется проверка ноутбука на прохождение \"Теста на Макбук\"...");
        noteBook.checkNoteBookToMacbookTest();
    }

    public static <T extends BeNoteBook> void checkBattery(T notebook) {
        System.out.println("Выполняется работа ноутбука от батареи...");
        notebook.workOnBattery();
    }
}
