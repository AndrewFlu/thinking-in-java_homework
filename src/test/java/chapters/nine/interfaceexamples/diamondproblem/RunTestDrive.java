package chapters.nine.interfaceexamples.diamondproblem;

public class RunTestDrive {
    public static void main(String[] args) {
        UniversalRunner runner = new UniversalRunner();
        Sprinter sprinter = new Sprinter();

        runner.runMarathon();
        sprinter.runSprint();
    }
}
