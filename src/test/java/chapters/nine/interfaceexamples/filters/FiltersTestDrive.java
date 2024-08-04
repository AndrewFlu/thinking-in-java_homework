package chapters.nine.interfaceexamples.filters;

import chapters.nine.interfaceexamples.processors.Apply;

public class FiltersTestDrive {

    public static void main(String[] args) {
        Waveform waveform = new Waveform();

        Filter low = new LowPass(2.5);
        Filter high = new HighPass(5.0);

        Apply.process(new FilterAdapter(low), waveform);
        Apply.process(new FilterAdapter(high), waveform);
    }
}
