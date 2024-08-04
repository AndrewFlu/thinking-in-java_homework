package chapters.nine.interfaceexamples.processors;

public class Apply {
    public static void process(Processor processor, Object input) {
        System.out.println("Using processor " + processor.name());
        System.out.println(processor.process(input));
    }
}
