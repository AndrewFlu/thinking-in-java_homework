package chapters.nine.interfaceexamples.diamondproblem;

public class UniversalRunner implements CanRun {
    @Override
    public void runMarathon() {
        System.out.println("Универсальный бегун бежит марафон");
    }

    @Override
    public void runSprint() {
        System.out.println("Универсальный бегун бежит спринт");
    }
}
