package chapters.nine.interfaceexamples.processors;

public class ProcessorTestDrive {
    private static final String string = "MacBook Pro 16 M1 Pro — is awesome!";

    public static void main(String[] args) {
        Apply.process(new Upcase(), string);
        Apply.process(new Downcase(), string);
        Apply.process(new Splitter(), string);
    }
}
