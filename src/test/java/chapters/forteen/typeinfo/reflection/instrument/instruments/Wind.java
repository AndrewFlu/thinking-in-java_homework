package chapters.forteen.typeinfo.reflection.instrument.instruments;

import chapters.forteen.typeinfo.reflection.instrument.Instrument;

public abstract class Wind implements Instrument {
    private void clearSpitValve() {
        System.out.println("Чистка мундштука");
    }

    @Override
    public void prepareInstrument() {
        clearSpitValve();
        tune();
    }
}
