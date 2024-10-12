package chapters.forteen.typeinfo.reflection.instrument.instruments;

import chapters.forteen.typeinfo.reflection.instrument.Instrument;

public abstract class Wind implements Instrument {
    public void clearSpitValve() {
        System.out.println("Чистка мундштука");
    }
}
