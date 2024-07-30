package chapters.eight.music;

import chapters.eight.music.instruments.Instrument;

public class Music3 {
    public static void main(String[] args) {
        Instrument[] orchestra = new Instrument[10];
        for (int i = 0; i < orchestra.length; i++) {
            orchestra[i] = InstrumentGenerator.next();
        }

        tuneAll(orchestra);
        System.out.println("");
        printAll(orchestra);
    }

    private static void printAll(Instrument[] orchestra) {
        for (Instrument i : orchestra) {
            System.out.println(i.what());
        }
    }

    private static void tuneAll(Instrument[] orchestra) {
        for (Instrument i : orchestra) {
            tune(i);
        }
    }

    private static void tune(Instrument instrument) {
        instrument.play(Note.MIDDLE_C);
    }
}
