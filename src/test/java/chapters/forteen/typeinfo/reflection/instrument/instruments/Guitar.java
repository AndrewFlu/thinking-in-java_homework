package chapters.forteen.typeinfo.reflection.instrument.instruments;

import chapters.forteen.typeinfo.reflection.instrument.Note;

public class Guitar extends Strings{


    @Override
    public void playNote(Note note) {
        System.out.println("Сыграть ноту " + note.getName() + " на гитаре");
    }

    @Override
    public void tune() {
        System.out.println("Настроить гитару по тюнеру, натяжкой или расслаблением струн");
    }
}
