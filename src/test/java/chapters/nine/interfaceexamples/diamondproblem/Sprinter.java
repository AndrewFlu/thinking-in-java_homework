package chapters.nine.interfaceexamples.diamondproblem;

public class Sprinter implements CanSprint {
    @Override
    public void runSprint() {
        System.out.println("Спринтер бежит спринт");
    }
}
