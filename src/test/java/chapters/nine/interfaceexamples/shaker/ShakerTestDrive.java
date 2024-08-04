package chapters.nine.interfaceexamples.shaker;

import chapters.nine.interfaceexamples.processors.Apply;
import chapters.nine.interfaceexamples.processors.Processor;

public class ShakerTestDrive {
    public static void main(String[] args) {
        String testString = "MacBookPro";
        String aBcD = "aBcD";
        String aBcDe = "aBcDe";

        Processor processor = new ShakerAdapter(new StringShaker());
        Apply.process(processor, testString);
        Apply.process(processor, aBcD);
        Apply.process(processor, aBcDe);
    }
}
