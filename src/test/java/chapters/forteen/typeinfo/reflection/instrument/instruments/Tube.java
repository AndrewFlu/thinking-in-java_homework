package chapters.forteen.typeinfo.reflection.instrument.instruments;

import chapters.forteen.typeinfo.reflection.instrument.Note;

public class Tube extends Wind{
    @Override
    public void playNote(Note note) {
        System.out.println("Сыграть ноту " + note.getName() + " на трубе");
    }

    @Override
    public void tune() {
        System.out.println("Настроить трубу выдвижением/задвиганием колена");
    }
}
