package chapters.fifteen.generics.constraints.homework;

import chapters.eight.music.Note;

public class LenovoThinPad extends NoteBook implements BeNoteBook {
    @Override
    public void workOnBattery() {
        System.out.println("Устройство способно работать до 3-х часов от аккумулятора, в течение 1 месяца после начала использования");
    }
}
