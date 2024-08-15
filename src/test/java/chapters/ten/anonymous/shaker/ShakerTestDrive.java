package chapters.ten.anonymous.shaker;

import chapters.nine.interfaceexamples.processors.Apply;
import chapters.nine.interfaceexamples.processors.Processor;

public class ShakerTestDrive {
    public static void main(String[] args) {
        String testString = "MacBookPro";
        String aBcD = "aBcD";
        String aBcDe = "aBcDe";

        Processor processor = new Processor() {
            private final StringShaker shaker = new StringShaker();

            @Override
            public String name() {
                return shaker.getName();
            }

            @Override
            public Object process(Object input) {
                return shaker.shake((String)input);
            }
        };

        Apply.process(processor, testString);
        Apply.process(processor, aBcD);
        Apply.process(processor, aBcDe);
    }
}