package chapters.nine.interfaceexamples.processors;

public class ProcessorTestDrive {
    private static final String string = "MacBook Pro 16 M1 Pro — is awesome!";

    public static void main(String[] args) {
        process(new Upcase(), string);
        process(new Downcase(), string);
        process(new Splitter(), string);
    }

    private static void process(Processor processor, String string) {
        System.out.println("Используется обработчик: " + processor.name());
        System.out.println(processor.process(string));
    }
}
