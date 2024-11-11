package chapters.fifteen.generics.constraints.homework;

public class NoteBookTestDrive {

    public static void main(String[] args) {
        MacBook macBookPro = new MacBook();
        NoteBookUtility.passMacBookTest(macBookPro);
        NoteBookUtility.checkBattery(macBookPro);

        LenovoThinPad thinkPad = new LenovoThinPad();
        NoteBookUtility.checkBattery(thinkPad);
    }
}
