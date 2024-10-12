package chapters.forteen.typeinfo.reflection.instrument.instruments;

import chapters.forteen.typeinfo.reflection.instrument.Instrument;

public abstract class Strings implements Instrument {
    @Override
    public void prepareInstrument() {
        tune();
    }
}
