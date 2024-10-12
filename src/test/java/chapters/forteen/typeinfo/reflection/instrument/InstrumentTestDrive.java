package chapters.forteen.typeinfo.reflection.instrument;

import chapters.forteen.typeinfo.reflection.instrument.instruments.Guitar;
import chapters.forteen.typeinfo.reflection.instrument.instruments.Tube;

public class InstrumentTestDrive {
    public static void main(String[] args) {
        Tube tube = new Tube();
        tube.playNote(Note.E);
        tube.tune();
        tube.playNote(Note.A);
        tube.clearSpitValve();

        System.out.println();
        Guitar acoustic = new Guitar();
        acoustic.playNote(Note.E);
    }
}
